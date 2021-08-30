# Roshambo

aka Rock-Paper-Scissors

An example project to demonstrate unit test code coverage and mutation testing.

## Branches

* `main` - begin here
* `mutation-coverage` - adds additional tests to increase mutation coverage
* `lizard-spock` - adds functionality to play Rock-Paper-Scissors-Lizard-Spock

## Building

To compile from scratch, run unit tests, and generate reports:

```console
$ mvn clean test site
```

The JaCoCo report is in `target/site/jacoco/`.

To generate mutation testing report:

```console
$ mvn pitest:mutationCoverage
```

The PIT report is in `target/pit-reports/YYYMMDDhhmm/`, where `YYYMMDDhhmm` is 
the date stamp.

## More information

* [PIT Maven Quick Start](https://pitest.org/quickstart/maven/)
* [Rock-Paper-Scissors-Lizard-Spock explanation](https://youtu.be/iSHPVCBsnLw?t=38) from The Big Bang Theory
