# Spring Boot AWS Publisher [![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

Demo project to showcase capabilites of Amazon SQS and SNS.

# Requirements
  - Java 11
  - Docker 19.03.xx
  - AWS CLI
  - Python 3

### Setup

Setup AWS region and credentials
```sh
$ aws configure
```

Setup AWS Local CLI
```sh
$ pip3 install awscli-local
```

Setup Localstack
```sh
$ pip3 install localstack
```

Create queues
```sh
$ awslocal sqs create-queue --queue-name aws.person.info.queue
$ awslocal sqs create-queue --queue-name aws.person.queue
```

List all queues
```sh
$ awslocal sqs list-queues
```

Get queue URL
```sh
$ awslocal sqs get-queue-url --queue-name aws.person.info.queue
```

Read a message from queue
```sh
$ awslocal sqs receive-message --queue-url http://localhost:4566/000000000000/aws.person.info.queue
```

Delete all messages from queue
```sh
$ awslocal sqs purge-queue --queue-url http://localhost:4566/000000000000/aws.person.info.queue
```

Create a topic
```sh
$ awslocal sns create-topic --name person-info-topic
```

List all topics
```sh
$ awslocal sns list-topics
```

Subscribe a queue to an SNS topic
```sh
$ awslocal sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:person-info-topic --protocol sqs --notification-endpoint arn:aws:sns:us-east-1:000000000000:aws.person.queue
```

List all subscriptions to a topic
```sh
$ awslocal sns list-subscriptions
```

Publish a message to a topic
```sh
$ awslocal sns publish --topic-arn arn:aws:sns:us-east-1:000000000000:person-info-topic --message "hello world"
```