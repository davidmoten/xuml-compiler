function getParameterByName(name) {

    var match = RegExp('[?&]' + name + '=([^&]*)')
                    .exec(window.location.search);

    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));

}

function midPoint(p1, p2) {
	return {
		left : (p1.left + p2.left) / 2,
		top : (p1.top + p2.top) / 2
	};
}

function weightedAverage(p1, p2, ratio) {
	return {
		left : (p1.left * ratio + (1 - ratio) * p2.left),
		top : (p1.top * ratio + (1 - ratio) * p2.top)
	};
}

function _testMidPoint() {
	var p1 = {
		left : 10,
		top : 20
	};
	var p2 = {
		left : 40,
		top : 100
	};
	var result = midPoint(p1, p2);
	if (result.left !== 25)
		alert("midPoint failed unit test 1!");
	if (result.top !== 60)
		alert("midPoint failed unit test 2!");
}

_testMidPoint();

function middle(element) {
	return {
		left : element.offset().left + element.width() / 2,
		top : element.offset().top + element.height() / 2
	};
}

/**
 * Returns determinant of this matrix: | a b | | c d |
 */
function det(a, b, c, d) {
	return a * d - b * c;
}

function _testDet() {
	if (det(1, 2, 3, 4) !== -2)
		alert("method det failed unit test!");
}

_testDet();

function lineIntersection(x1, y1, x2, y2, x3, y3, x4, y4) {
	// See Wolfram Mathworld
	// http://mathworld.wolfram.com/Line-LineIntersection.html
	var denom = det(x1 - x2, y1 - y2, x3 - x4, y3 - y4);
	if (denom == 0)
		return null;// lines are parallel

	var d1 = det(x1, y1, x2, y2);
	var d2 = det(x3, y3, x4, y4);
	var x = det(d1, x1 - x2, d2, x3 - x4) / denom;
	var y = det(d1, y1 - y2, d2, y3 - y4) / denom;
	return {
		left : x,
		top : y
	};
}

function _testLineIntersection() {
	var answer = lineIntersection(1, 7, 2, 11, 3, 18, 4, 19);
	if (answer.left !== 4)
		alert("line intersection failed unit test 1!");
	if (answer.top !== 19)
		alert("line intersection failed unit test 2!");
	answer = lineIntersection(1, 7, 2, 11, 3, 15, 4, 19);
	if (answer !== null)
		alert("line intersection failed unit test 3!");
}

_testLineIntersection();

function intersection(a, b, c, d) {
	return lineIntersection(a.left, a.top, b.left, b.top, c.left, c.top,
			d.left, d.top);
}

function onElement(point, e) {
	var p = e.offset();
	var tolerance = 1;
	return point.left >= p.left - tolerance && point.top >= p.top - tolerance
			&& point.left <= p.left + e.width() + tolerance
			&& point.top <= p.top + e.height() + tolerance;
}

function elementBorderIntersection(point, e) {
	var mid = middle(e);
	var p1 = e.offset();
	var p2 = {
		left : p1.left + e.width(),
		top : p1.top
	};
	var p3 = {
		left : p1.left + e.width(),
		top : p1.top + e.height()
	};
	var p4 = {
		left : p1.left,
		top : p1.top + e.height()
	};
	var i1 = intersection(p1, p2, mid, point);
	var i2 = intersection(p2, p3, mid, point);
	var i3 = intersection(p3, p4, mid, point);
	var i4 = intersection(p4, p1, mid, point);
	var intersections = [ i1, i2, i3, i4 ];
	var closestIndex = -1;
	var closestDistance = -1;
	for ( var i = 0; i < intersections.length; i++) {
		if (intersections[i] !== null && onElement(intersections[i], e)) {
			var dist = distance(point, intersections[i]);
			if (closestIndex == -1 || dist < closestDistance) {
				closestIndex = i;
				closestDistance = dist;
			}
		}
	}
	result = intersections[closestIndex];
	result.side = closestIndex + 1;
	return result;
}

function _testElementBorderIntersection() {
	var e = {
		offset : function() {
			return {
				left : 0,
				top : 0
			};
		},
		height : function() {
			return 100;
		},
		width : function() {
			return 120;
		}
	};
	var answer;
	answer = elementBorderIntersection({
		left : 200,
		top : 50
	}, e);
	if (answer.left !== 120)
		alert("elementBorderIntersection failed unit test 1!");
	if (answer.top !== 50)
		alert("elementBorderIntersection failed unit test 2!");
	if (answer.side != 2)
		alert("elementBorderIntersection failed unit test 2.1");

	answer = elementBorderIntersection({
		left : 60,
		top : 200
	}, e);
	if (answer.left !== 60)
		alert("elementBorderIntersection failed unit test 3!");
	if (answer.top !== 100)
		alert("elementBorderIntersection failed unit test 4!");
	if (answer.side != 3)
		alert("elementBorderIntersection failed unit test 4.1");

	answer = elementBorderIntersection({
		left : 0,
		top : 60
	}, e);
	if (answer.left !== 0)
		alert("elementBorderIntersection failed unit test 5!");
	if (answer.top !== 60)
		alert("elementBorderIntersection failed unit test 6!");
	if (answer.side != 4)
		alert("elementBorderIntersection failed unit test 6.1");

	answer = elementBorderIntersection({
		left : -100,
		top : 50
	}, e);
	if (answer.left !== 0)
		alert("elementBorderIntersection failed unit test 7!");
	if (answer.top !== 50)
		alert("elementBorderIntersection failed unit test 7.1!");
	if (answer.side != 4)
		alert("elementBorderIntersection failed unit test 7.2");

}

_testElementBorderIntersection();

function plus(p1, p2) {
	return {
		left : (p1.left + p2.left),
		top : (p1.top + p2.top)
	};
}

function minus(p1, p2) {
	return {
		left : (p1.left - p2.left),
		top : (p1.top - p2.top)
	};
}

function distance(p1, p2) {
	return Math.sqrt(Math.pow(p1.left - p2.left, 2)
			+ Math.pow(p1.top - p2.top, 2));
}

function mark(p, ctx) {
	ctx.fillRect(p.left - 5, p.top - 5, 10, 10);
}

function setPosition(element, x, y) {
	element.css("left", x + "px");
	element.css("top", y + "px");
}

function magnitude(p) {
	return distance(p, {
		left : 0,
		top : 0
	});
}

function towards(p1, p2, distance) {
	var p3 = cartesianToPolar(minus(p2, p1));
	var p4 = {
		r : distance, 
		theta : p3.theta
	};
	var p5 = polarToCartesian(p4);
	return plus(p5, p1);
}

function cartesianToPolar(p) {
	return {
		r : magnitude(p),
		theta : Math.atan2(p.top, p.left)
	};
}

function polarToCartesian(p) {
	return {
		left : p.r * Math.cos(p.theta),
		top : p.r * Math.sin(p.theta)
	};
}

function rotateAbout(p, origin, degrees) {
	var p2 = minus(p, origin);
	var p3 = cartesianToPolar(p2);
	var p4 = {
		r : p3.r,
		theta : p3.theta + Math.PI / 180.0 * degrees
	};
	var p5 = polarToCartesian(p4);
	var p6 = plus(p5, origin);
	return p6;
}

var relationshipMidpoints = new Object();

function getRelationshipMidpoint(relationshipName) {
	return relationshipMidpoints[relationshipName];
}

function placeVerbClause(e, p, inDirection) {
	var x = cartesianToPolar(minus(inDirection, p));
	if (p.side == 1) { // top
		var delta;
		if (Math.abs(x.theta) == Math.PI / 2 || x.theta == 0)
			delta = 0;
		else if (x.theta < -Math.PI / 2) {
			var t = Math.tan(Math.PI + x.theta);
			delta = (e.height() + 2 * 5) / t;
		} else
			delta = 0;
		setPosition(e, p.left - delta - 5 - e.width(), p.top - 5 - e.height());
	} else if (p.side == 2) { // right
		var delta;
		if (Math.abs(x.theta) == Math.PI / 2 || x.theta == 0)
			delta = 0;
		else if (x.theta <= 0) {
			var t = Math.tan(Math.PI / 2 + x.theta);
			delta = (e.width() + 2 * 5) / t;
		} else
			delta = 0;
		setPosition(e, p.left + 15, p.top - 5 - delta - e.height());
	} else if (p.side == 3) {// bottom
		var delta;
		if (Math.abs(x.theta) == Math.PI / 2 || x.theta == 0)
			delta = 0;
		else if (x.theta > Math.PI / 2) {
			var t = Math.tan(Math.PI - x.theta);
			delta = (e.height() + 2 * 5) / t;
		} else
			delta = 0;
		setPosition(e, p.left - delta - e.width() - 5, p.top + 10);
	} else if (p.side == 4) {// left
		var delta;
		if (Math.abs(x.theta) == Math.PI / 2 || x.theta == 0)
			delta = 0;
		else if (x.theta <= -Math.PI / 2) {
			var t = Math.tan(-Math.PI / 2 - x.theta);
			delta = (e.width() + 2 * 5) / t;
		} else
			delta = 0;
		setPosition(e, p.left - e.width() - 5, p.top - e.height() - delta - 5);
	} else
		alert("should not get here");
}

function placeMultiplicity(e, p) {
	if (p.side == 1) // top
		setPosition(e, p.left + 15, p.top - e.height() - 5);
	else if (p.side == 2) // right
		setPosition(e, p.left + 15, p.top + e.height() + 5);
	else if (p.side == 3) // bottom
		setPosition(e, p.left + 15, p.top + 10);
	else if (p.side == 4) // bottom
		setPosition(e, p.left - e.width() - 5, p.top + e.height() + 5);
	else
		alert("should not get here");
}

function paintRelationships(c, ctx) {
	$(".relationship").each(function() {
		var rel = $(this);
		var w1 = $("#" + rel.attr("className1"));
		var w2 = $("#" + rel.attr("className2"));
		var middle1 = middle(w1);
		var middle2 = middle(w2);
		var mid = midPoint(middle1, middle2);
		var i1 = elementBorderIntersection(mid, w1);
		var i2 = elementBorderIntersection(mid, w2);

		var midAdjusted = minus(mid, c);
		relationshipMidpoints[rel.attr("id")] = midAdjusted;
		var p1 = minus(i1, c);
		var p2 = minus(i2, c);
		ctx.moveTo(p1.left, p1.top);
		ctx.lineTo(p2.left, p2.top);

		rel.find(".relationshipName").each(function() {
			var label = $(this);
			label.text(rel.attr("id"));
			setPosition(label, mid.left - 10, mid.top - 10);
		});

		var angle = 17;
		rel.find(".verbClause1").each(function() {
			placeVerbClause($(this), i1, mid);
		});
		rel.find(".verbClause2").each(function() {
			placeVerbClause($(this), i2, mid)
		});
		rel.find(".multiplicity1").each(function() {
			placeMultiplicity($(this), i1);
		});
		rel.find(".multiplicity2").each(function() {
			placeMultiplicity($(this), i2);
		});
	});
}

CanvasRenderingContext2D.prototype.dashedLineTo = function(fromX, fromY, toX,
		toY, pattern) {
	// Our growth rate for our line can be one of the following:
	// (+,+), (+,-), (-,+), (-,-)
	// Because of this, our algorithm needs to understand if the x-coord
	// and
	// y-coord should be getting smaller or larger and properly cap the
	// values
	// based on (x,y).
	var lt = function(a, b) {
		return a <= b;
	};
	var gt = function(a, b) {
		return a >= b;
	};
	var capmin = function(a, b) {
		return Math.min(a, b);
	};
	var capmax = function(a, b) {
		return Math.max(a, b);
	};

	var checkX = {
		thereYet : gt,
		cap : capmin
	};
	var checkY = {
		thereYet : gt,
		cap : capmin
	};

	if (fromY - toY > 0) {
		checkY.thereYet = lt;
		checkY.cap = capmax;
	}
	if (fromX - toX > 0) {
		checkX.thereYet = lt;
		checkX.cap = capmax;
	}

	this.moveTo(fromX, fromY);
	var offsetX = fromX;
	var offsetY = fromY;
	var idx = 0, dash = true;
	while (!(checkX.thereYet(offsetX, toX) && checkY.thereYet(offsetY, toY))) {
		var ang = Math.atan2(toY - fromY, toX - fromX);
		var len = pattern[idx];

		offsetX = checkX.cap(toX, offsetX + (Math.cos(ang) * len));
		offsetY = checkY.cap(toY, offsetY + (Math.sin(ang) * len));

		if (dash)
			this.lineTo(offsetX, offsetY);
		else
			this.moveTo(offsetX, offsetY);

		idx = (idx + 1) % pattern.length;
		dash = !dash;
	}
};

function paintAssociationClasses(c, ctx) {
	$(".associationClass").each(function() {
		var e = $(this);
		var w = $("#" + e.attr("id"));
		var p1 = middle(w);
		var p2 = getRelationshipMidpoint(e.attr("relationshipName"));
		var mid = midPoint(p1, p2);
		var i1 = elementBorderIntersection(mid, w);

		p1 = minus(i1, c);
		ctx.moveTo(p1.left, p1.top);
		ctx.dashedLineTo(p1.left, p1.top, p2.left, p2.top, [ 5, 5 ]);
	});
}

function paintGeneralizations(c, ctx) {
	$(".generalization").each(function() {
		var gen = $(this);
		var w1 = $("#" + gen.attr("subClassName"));
		var w2 = $("#" + gen.attr("superClassName"));
		var p1 = middle(w1);
		var p2 = middle(w2);
		var mid = midPoint(p1, p2);
		var i1 = elementBorderIntersection(mid, w1);
		var i2 = elementBorderIntersection(mid, w2);

		p1 = minus(i1, c);
		p2 = minus(i2, c);

		var arrowSize = 20;
		var p2close = towards(p2, p1, 5);
		var p3 = towards(p2close, p1, arrowSize);
		ctx.moveTo(p1.left, p1.top);
		// draw arrow
		var angle = 30;
		var p4 = rotateAbout(p3, p2close, angle);
		var p5 = rotateAbout(p3, p2close, -angle);
		var midRear = midPoint(p4, p5);
		ctx.lineTo(midRear.left, midRear.top);
		ctx.lineTo(p4.left, p4.top);
		ctx.lineTo(p2close.left, p2close.top);
		ctx.lineTo(p5.left, p5.top);
		ctx.lineTo(midRear.left, midRear.top);

		var mid = plus(midPoint(p1, p2), c);

		setPosition(gen, mid.left - 10, mid.top - 5);
		gen.text(gen.attr("groupName"));

	});
}

function repaint() {
	var canvas = $("#canvas")[0];
	// canvas.width = 5*window.innerWidth;
	// canvas.height = 5*window.innerHeight;
	var c = $("#canvas").offset();
	var ctx = canvas.getContext("2d");
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	ctx.beginPath();
	relationshipMidpoints = new Object();
	paintRelationships(c, ctx);
	paintGeneralizations(c, ctx);
	paintAssociationClasses(c, ctx);
	ctx.stroke();
	ctx.closePath();
}

function createDivs() {
	$(".relationship").each(
			function() {
				var e = $(this);
				e.append('<div class="relationshipName">' + e.attr("id")
						+ "</div>");
				e.append('<div class="verbClause1">' + e.attr("verbClause1")
						+ "</div>");
				e.append('<div class="verbClause2">' + e.attr("verbClause2")
						+ "</div>");
				e.append('<div class="multiplicity1">'
						+ e.attr("multiplicity1") + "</div>");
				e.append('<div class="multiplicity2">'
						+ e.attr("multiplicity2") + "</div>");
			});
	$(".cls").each(
			function() {
				var e = $(this);
				e.prepend('<div id="className' + e.attr("id")
						+ '" class="className">' + e.attr("id") + "</div>");
				// make sure header comes before class name
				e.find(".header").each(function() {
					var h = $(this);
					h.insertBefore("#className" + e.attr("Id"));
				});
			});
}

var webStorage = getParameterByName("web") !== "false";

function saveToWeb(id, property, value, success) {
	jQuery.post("ds", {
		entity: "1",
		property : property,
		value : value
	}, success);
}

function getFromWeb(id, property, success) {
	jQuery.get("ds", {
		entity: "1",
		property : property,
		mime: "text/plain"
	}, success);
}

function createSave() {
	$("body").prepend("<div id='save' class='save noprint'>Save</div>");
	$("#save").click(function() {
		$(this).text("Saving...");
		var presentation = buildPresentationJson();
		console.log("saved presentation="+presentation);
		if (webStorage) {
			saveToWeb("1", "presentation", presentation, function(data) {
				$("#save").text("Save");
			});
		} else {
			localStorage.setItem("positions", presentation);
			window.setTimeout(function () {
	    		$("#save").text("Save");
			}, 300);	
		}
	});
}

function restorePresentationFromWeb(presentation) {
	console.log("restoring presentation="+presentation);
	if (presentation !== undefined && presentation.length>0) {
		restoreFromObject(JSON.parse(presentation));
		repaint();
	}
}

function restore() {
	$("#restore").text("Restoring...");
	if (webStorage) {
		getFromWeb("1","presentation",restorePresentationFromWeb);
	} else {
		var presentation = localStorage.getItem("positions");
		restoreFromJSON(presentation);
		window.setTimeout(function () {
    		$("#restore").text("Restore");
		}, 300);	
	}
}

function restoreFromJSON(x) {
	var o = jQuery.parseJSON(x);
	restoreFromObject(o);
}

function restoreFromObject(x) {
	if (x == undefined || x == null) return;
	$('.cls').each(function() {
		var e = $(this);
		var id = e.attr("id");
		if (id !== undefined) {
			e.css("left", x[id].left);
			e.css("top", x[id].top);
		}
	});
}

function buildPresentationJson() {
	var o = new Object();
	$('.cls').each(function() {
		var e = $(this);
		var id = e.attr("id");
		o[id] = new Object();
		o[id].left = e.css("left");
		o[id].top = e.css("top");
	});
	return JSON.stringify(o);
}

function createRestore() {
	$("body")
			.prepend("<div id='restore' class='restore noprint'>Restore</div>");
	$("#restore").click(function() {
		restore();
	}); 
}

function createOptions() {
	$("body")
			.prepend(
					"<div id='options-editor' class='options-editor' title='Options'><input id='restoreOnLoad' type='checkbox' name='restoreOnLoad' value='true'> Restore on load</div>");
	$("body")
			.prepend("<div id='options' class='options noprint'>Options</div>");
	var options = $("#options");
	var optionsEditor = $("#options-editor");
	optionsEditor.dialog({
		autoOpen : false
	});
	options.click(function() {
		optionsEditor.dialog('open');
	});
	$("#restoreOnLoad").change(function() {
		var checked = $(this).is(':checked');
		localStorage.setItem("restoreOnLoad", checked);
	});
	if (localStorage.getItem("restoreOnLoad") != "false") {
		restore();
		$("#restoreOnLoad").attr("checked", "true");
	}
}

function createEdit() {
	$("body").prepend("<div id='edit' class='edit noprint'>Edit</div>");

}

function makeDraggable() {
	var dragListener = {
		start : function() {
			repaint();
		},
		drag : function() {
			repaint();
		},
		stop : function() {
			repaint();
		}
	};

	var resizeListener = {
		start : function() {
			repaint();
		},
		resize : function() {
			repaint();
		},
		stop : function() {
			repaint();
		}
	};
	resizeListener.handles = '';
	$(".draggable").draggable(dragListener);// .resizable(resizeListener);
}

function setup() {
	createDivs();
	createOptions();
	createSave();
	createRestore();
	createEdit();
	makeDraggable();
	repaint();
}
