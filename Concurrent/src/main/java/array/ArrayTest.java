package array;

/**
 *
 * 数组的初始化有2种，静态和动态
 * 静态：显示指定每个数组元素的初始值，由系统决定数组长度
 * 动态：程序员指定数组长度，系统为数组元素分配初始值。
 *
 * @author: wuchao
 * @date： 2017/3/10
 */
public class ArrayTest {

    public static void main(String[] args) {

        //采用静态初始化方式初始的第一个数组
        String[]books = new String[] {
                "a", "b","c","d"
        };

        //采用静态初始化的简化形式初始化第二个数组
        String [] names = {"m","n","q"};

        String[] strArr = new String[5];

        System.out.println("第一个数组的长度" + books.length);
        System.out.println("第二个数组的长度" + names.length);
        System.out.println("第三个数组的长度" + strArr.length);
    }


}
