
public class InfixtoPostfix {
    public static void main(String[] args) {
        String str = "[a*(b-[e*f/g])]";
        System.out.println("\t* Infix Expresion : "+str);
        System.out.println("\t* Postfix Expresion : "+intoPost(str));
    }
    static String intoPost(String str){
        DemoCharStack st = new DemoCharStack();  //main stack :
        String result = "";
        for(int i = 0 ; i< str.length();i++){
            char ch = str.charAt(i);
            if((ch>='a'&&ch<'z')||(ch>='a'&&ch<'z')||(ch>='0'&&ch<'9')){
                result = result + ch;
            }
            else if (ch=='('||ch=='['||ch=='{'){
                st.push(ch);//push opening br:
            }
            else if (ch==')'||ch==']'||ch=='}'){
                while(!st.isEmpty()&&(isBracket(st.peek()))){
                    result = result + st.pop();
                }
            }
            else {
                //check precedance :
                while((!st.isEmpty()&&prec(ch)<=prec(st.peek()))){
                    result = result + st.pop();
                }
                st.push(ch);   //push operators into stack: 
            }
        }
        //add remening element of stack into string : 
        while(!st.isEmpty()){
            if(isBracket(st.peek())){
            result = result+st.pop();
            }
            st.pop();
        }
        return result;
    }
    static int prec(char c){ //method to check precedance : 
        if(c=='^')return 4;
        if(c=='*'||c=='/')return 3;
        if(c=='+'||c=='-')return 2;
        if(c=='('||c=='['||c=='{')return 1;
        else return 0;
    }

    static boolean isOperator(char c){ //method to check c is operetor or not:
        if(c=='*'||c=='/'||c=='+'||c=='-'||c=='.')return true;
        else return false;
    }
    static boolean isBracket(char c){ //method to check c is bracket or not:
        if(c=='{'||c=='['||c=='(')
        {
            return false;
        }
        return true;
    }
}

