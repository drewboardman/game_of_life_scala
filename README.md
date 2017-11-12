Conway's Game of Life
====================

## Rules

 1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
 2. Any live cell with two or three live neighbours lives on to the next generation.
 3. Any live cell with more than three live neighbours dies, as if by over-population.
 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

TODO
----
 * add scalaStyle
 * add wartRemover
 * right now Board has multiple applys
  - I originally had an apply that take `Vector[Vector[Cell]]` and a `generate` that took `String => Board`
 * object Cell#convert
    - should that somehow be on the trait?
    - maybe it should be in a totally seperate file `CellConverter`
