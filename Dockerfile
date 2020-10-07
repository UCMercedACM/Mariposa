FROM maven:latest

LABEL maintainer="UCM ACM Chapter"
LABEL maintainer.email="acm@ucmerced.edu"

WORKDIR /home

COPY . /home

CMD [ "./mvnw",  "spring-boot:run"]