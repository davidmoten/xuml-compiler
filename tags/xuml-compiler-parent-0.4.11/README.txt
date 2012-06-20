Build:
  
  mvn clean install
	  
Dry run of release:

  mvn release:prepare -DdryRun=true -DautoVersionSubmodules=true
  mvn release:clean
  
Do release:
  
  mvn release:prepare -DautoVersionSubmodules=true
  mvn release:perform
  
Or

Do everything at once

  mvn clean install release:prepare -DautoVersionSubmodules=true mvn release:perform

To deploy snapshot to AMSA internal repository:

  mvn clean deploy -Ddistribution.id=amsa-maven -Ddistribution.url=http://sardevc.amsa.gov.au:8081/artifactory/libs-snapshots-local
