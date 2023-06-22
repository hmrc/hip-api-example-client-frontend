# hip-api-example-client-frontend

This is an example front end application, which will interact with a counterpart example backend for the 
purposes of interacting with The API Hub.

For more information on the project please visit this space in Confluence:
https://confluence.tools.tax.service.gov.uk/display/AH/The+API+Hub+Home

## Requirements

This service is written in [Scala](http://www.scala-lang.org/) and [Play](http://playframework.com/), so needs at least a [JRE] to run.

## Dependencies
Beyond the typical HMRC Digital platform dependencies this service relies on:
- hip-api-example-client

You can view service dependencies using the Tax Catalogue's Service Relationships
section here:
https://catalogue.tax.service.gov.uk/service/hip-api-example-client-frontend

### hip-api-example-client
This is an example backend that interacts with a HIP API. Note that this can
only be deployed in QA and production.

## Using the service

### Running the application

To run the application use `sbt run` to start the service.

Note that this service cannot actually function locally as the backend is only 
deployed in QA and production.

### Authentication
This service does not authenticate incoming requests.

## Building the service
This service can be built on the command line using sbt.
```
sbt compile
```

### Unit tests
This microservice has many unit tests that can be run from the command line:
```
sbt test
```

### Integration tests
This microservice has some integration tests that can be run from the command line:
```
sbt it:test
```

### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
