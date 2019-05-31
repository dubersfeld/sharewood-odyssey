FROM mysql

# Environment variables
ENV MYSQL_ROOT_PASSWORD strata15

# Create Database

COPY ["./sharewoodPhotoDB.sql", "/docker-entrypoint-initdb.d"] # push forward
