public class Tree {
    int value;
    Tree left, right;
    static boolean flag = false;

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Tree() {
    }



    public static Tree CreateTree1() {
        Tree tree_one = new Tree(20,
                new Tree(7,
                        new Tree(4, null, new Tree(6, null, null)),
                        new Tree(9, null, null)),
                new Tree(35,
                        new Tree(31,
                                new Tree(28,
                                        null, null), null),
                        new Tree(40,
                                new Tree(38, null, null),
                                new Tree(52, null, null))));
        return tree_one;
    }

    public static Tree CreateTree2() {
        Tree tree_two = new Tree(20,
                new Tree(35,
                        new Tree(31,
                                new Tree(28, null, null), null),
                        new Tree(40,
                                new Tree(52, null, null),
                                new Tree(38, null, null))),
                new Tree(7,
                        new Tree(9, null, null),
                        new Tree(4, null, new Tree(6, null, null))));
        return tree_two;
    }

    public int sum() {
        System.out.println(value);
        int sum = value;
        if (left != null) {
            //System.out.println(this.value);
            sum += left.sum();
        }
        if (right != null) {
            //System.out.println(this.value);
            sum += right.sum();
        }

        return sum;
    }

    public static void is_similar(Tree tree_one, Tree tree_two) {
        if(flag) {
            //если есть хоть какой-то путь из вершин
            if ((tree_one.left != null || tree_one.right != null) || (tree_two.left != null || tree_two.right != null)) {
                //если оба ребенка есть
                if (tree_one.left != null && tree_two.left != null && tree_one.right != null && tree_two.right != null) {
                    //если они попарно равны
                    if (tree_one.left.value == tree_two.left.value && tree_one.right.value == tree_two.right.value) {
                        flag = true;
                        is_similar(tree_one.left, tree_two.left);
                        is_similar(tree_one.right, tree_two.right);
                    }
                    //если они равны сикось накось
                    else if (tree_one.left.value == tree_two.right.value && tree_one.right.value == tree_two.left.value) {
                        flag = true;
                        is_similar(tree_one.left, tree_two.right);
                        is_similar(tree_one.right, tree_two.left);
                    } else {
                        flag = false;
                        return;
                    }
                }
                //если нет левых детей
                else if (tree_one.left == null && tree_two.left == null) {
                    if (tree_one.right.value == tree_two.right.value) {
                        flag = true;
                        is_similar(tree_one.right, tree_two.right);
                    } else {
                        flag = false;
                        return;
                    }
                }
                //если нет правых детей
                else if (tree_one.right == null && tree_two.right == null) {
                    if (tree_one.left.value == tree_two.left.value) {
                        flag = true;
                        is_similar(tree_one.left, tree_one.left);
                    } else {
                        flag = false;
                        return;
                    }
                }
            }
        }
    }


    public static void main (String[]args) {
        Tree tree_1 = CreateTree1();
        Tree tree_2 = CreateTree2();
        if (tree_1.value == tree_2.value) {
            flag = true;
            is_similar(tree_1, tree_2);
        }
        if(flag) {
            System.out.println("Is similar");
        }
        else {
            System.out.println("Not similar");
        }
    }

}


