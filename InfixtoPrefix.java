import java.net.NetPermission;

public class InfixtoPrefix {
    
    public static void main(String[] args) {
        String str = "[a*(b-[e*f/g])]";
        System.out.println("\t* Infix Expresion : "+str);
        StringBuffer str2 = new StringBuffer(intoPost(str));
        System.out.println("\t* Postfix Expresion : "+str2.reverse());
    }
    static String intoPost(String str){
        GStack<Character> st = new GStack<>();  //main stack :
        String result = "";
        for(int i = (str.length()-1) ; i >= 0;i--){
            Character ch = str.charAt(i);
            if((ch>='a'&&ch<'z')||(ch>='a'&&ch<'z')||(ch>='0'&&ch<'9')){
                result = result + ch;
            }
            else if (ch==')'||ch==']'||ch=='}'){
                st.push(ch);//push opening br:
            }
            else if (ch=='('||ch=='['||ch=='{'){
                while(!st.isEmpty()&&(st.isBracket(st.peek()))){
                    result = result + st.pop();
                }
            }
            else {
                //check precedance :
                while((!st.isEmpty()&&st.precforpre(ch)>=st.precforpre(st.peek()))){
                    result = result + st.pop();
                }
                st.push(ch);   //push operators into stack: 
            }
        }
        //add remening element of stack into string : 
        while(!st.isEmpty()){
            if(st.isBracket(st.peek())){
            result = result+st.pop();
            }
            st.pop();
        }
        return result;
    }
    static boolean isOperator(char c){ //method to check c is operetor or not:
        if(c=='*'||c=='/'||c=='+'||c=='-'||c=='.')return true;
        else return false;
    }

}
