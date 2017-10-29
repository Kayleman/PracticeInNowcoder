package kayle.practice.nowcoder;

/*
 * 题目描述:
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 解题思路:
 * 一开始看到这题,我直接用了split来对str进行切分,但是在提交的时候,发现测试里面有纯空格的str
 * 所以要用split还得考虑到这一点,所以干脆不用split
 * 这题考察的主要是对字符串的翻转
 * 首先对整个字符串进行翻转,翻转完毕之后再对每一个单词进行翻转
 * 可以设置两个指针,分别指向单词的前后空格的坐标,来记录应该翻转的单词的位置区间
 * 都翻转完成后,由于最后一个单词后面是没有空格的,所以在循环中是不会被翻转的
 * 需要最后单独翻转
 * */
public class ReverseSentence {
    public static String reverseSentence(String str) {
    	char [] array = str.toCharArray();
    	reverse(array, 0, array.length - 1);
    	int leftBlank = -1;
    	for(int i = 0; i < array.length; i++){
    		if(array[i] == ' ') {
    			int rightBlank = i;
    			reverse(array, leftBlank + 1, rightBlank - 1);
    			leftBlank = rightBlank;
    		}
    	}
    	//翻转最后一个单词
    	reverse(array, leftBlank + 1, array.length - 1);
    	String res = String.valueOf(array);
    	return res;
    }
    
    private static void reverse(char [] array, int left, int right) {
    	while(left < right) {
    		char temp = array[left];
    		array[left] = array[right];
    		array[right] = temp;
    		left++;
    		right--;
    	}
    }
    public static void main(String[] args) {
		System.out.println(reverseSentence("   1"));
	}
}

