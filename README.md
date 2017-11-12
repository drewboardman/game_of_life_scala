Conway's Game of Life
====================

## Rules

 1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
 2. Any live cell with two or three live neighbours lives on to the next generation.
 3. Any live cell with more than three live neighbours dies, as if by over-population.
 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

## Usage

You'll probably need to install javafx. On Ubuntu install the following package

```
sudo apt-get install openjfx
```

Clone the repo, run the application

```
sbt
sbt:game-of-life> run
```

Right now there isn't any user input. To try another board, simply add it to the `BoardTemplates` object.
  - You'll need to change the line in `Game#start` to use your new template
  - You are also restricted to `n * n` board sizes

TODO
----
- allow for better user input
  - ability to add and select boards through a cli
- Maybe kill cells at borders of `Board`

#### Possible code tweaks
- right now `Board` has multiple applys
  - it's nice that different argument types work
  - I originally had an apply that take `Vector[Vector[Cell]]` and a `generate` that took `String => Board`
    - this could be more expressive than using `apply`, it seems subjective either way
- object `Cell` has a method `convert`
  - maybe it should be in a seperate object `CellConverter`
- Would like to convert `Board#tick` to use for comprehension
  - they get weird about `Vector` vs `IndexedSeq`
