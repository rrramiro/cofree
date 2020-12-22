## Pure Functional Database Programming with Fixpoint Types

This is an attempt of upgrade of the slides and examples of a great presentation of Rob Norris @tpolecat.
Here are the original [slides](http://tpolecat.github.io/presentations/sw2016/slides.html) and [video](https://www.youtube.com/watch?v=7xSfLPD6tiQ) from Scala World 2016. Press `?` for help with the slides.

#### Compiling and Running the Companion Code

The build assumes a live Postgres database with a `postgres` user with no password and a `prof` database.
If you wish to use a different user you can edit the settings in `src/main/scala/cofree.scala` and `docker-compose.yml`.

    docker-compose up

or

    psql -c 'create user postgres createdb'
    psql -c 'create database prof' -U postgres
    psql -c '\i create.sql' -d prof -U postgres

#### Compiling the Slides

If you wish to build the slides for some reason, type `mdoc` at the sbt prompt. The output will apppear in the `target/mdoc/slides.html` directory.
