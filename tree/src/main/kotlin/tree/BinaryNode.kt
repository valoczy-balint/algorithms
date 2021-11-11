package tree

class BinaryNode<T>(
    var value: T,
) {
    var left: BinaryNode<T>? = null
    var right: BinaryNode<T>? = null
    var parent: BinaryNode<T>? = null
}
