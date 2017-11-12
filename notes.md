#### Possible code tweaks
- right now `Board` has multiple applys
  - it's nice that different argument types work
  - I originally had an apply that take `Vector[Vector[Cell]]` and a `generate` that took `String => Board`
    - this could be more expressive than using `apply`, it seems subjective either way
- object `Cell` has a method `convert`
  - maybe it should be in a seperate object `CellConverter`
- Would like to convert `Board#tick` to use for comprehension
  - they get weird about `Vector` vs `IndexedSeq`
