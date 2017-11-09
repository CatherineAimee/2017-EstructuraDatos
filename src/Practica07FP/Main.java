/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica07FP;

/**
 *
 * @author Neil
 */
public class Main {
	
	public static String checkForBalance(String expression) { 
            Stack <String> Pila; Pila = new Stack <String>();
            for(int i=0 ;i<expression.length() ;i++){
                char Symbol = expression.charAt(i);
                
                if(Symbol == '(' || Symbol== '{' || Symbol == '[' ){
                    Pila.push(String.valueOf(Symbol));
                }
                
                if(Symbol == ')' || Symbol== '}' || Symbol == ']' ){
                    if(Pila.empty()){
                        return "Missing left for" + Symbol;
                    }
                }
                    if(Symbol == ')'){
                        if(Pila.peek() != "("){
                            return "Missing left symbol";
                        }
                        else{
                            Pila.pop();
                        }
                        break;
                    }
                    if(Symbol == '}' ){
                        if(Pila.peek() != "{"){
                            return "Missing left symbol";
                        }
                        else{
                            Pila.pop();
                        }
                        break;
                    }
                    if(Symbol == ']' ){
                        if(Pila.peek() != "["){
                            return "Missing left symbol";
                        }
                        else{
                            Pila.pop();
                        }
                        break;
                    }      
                }
            
            if(!Pila.empty())
                return "Missing right of: " + Pila.peek().toString();
            
            return "The code is balanced";
        }
        public static String CheckForBalance(String expr){
        char[] chars=expr.toCharArray();        //pasa la expresión a un arreglo de caracteres
        Stack st = new Stack();             //crea una fila
        
        for(int i=0;i<chars.length;i++){        //se recorre el arreglo
            char current=chars[i];              //current = el de ahorita
            
            if(current=='{'||current=='('||current=='['){       //si current es bla
                st.push(current);                               //lo mete a la pila
            }
            if(current=='}'||current==')'||current==']'){               //si es el derecho
                if(st.empty()){
                    return "Missing left for    "+current;              //pregunta si 
                }
                switch(current){
                    case'}':
                        if(!st.peek().equals('{')){
                            return "Missing left for "+current;
                        }
                        else{
                            st.pop();
                        }
                    break;
                    case')':
                        if(!st.peek().equals('(')){
                            return "Missing left for "+current;
                        }    
                        else{
                            st.pop();
                        }
                    break;
                    case']':
                        if(!st.peek().equals('[')){
                            return "Missing left for "+current;    
                        }
                    else{
                            st.pop();
                        }
                    break;
                }
            }
        
        }
    if(!st.empty()){
        return "Missing right for "+st.peek().toString();
        }    
    return "The code is balanced";
    }
        
	public static String postfixEval(String expression) {   
            Stack <String> Pila; Pila = new Stack <String>();   //Se crea una pila 
            int res;
            
            for(int i=0 ;i<expression.length() ;i++){           //se recorre cada caracter
                char Symbol = expression.charAt(i);         //y se guarda como Symbol
                
                if(Character.isDigit(Symbol)){              //si el simbolo es un digito
                    Pila.push(String.valueOf(Symbol));      //se mete a una pila
                }
                
                else if(Symbol != ' '){             //si NO es un digito Ni espacio 
                    
                    if(Pila.empty()){               //si la pila está vacia
                        return "The expression has too many operators";         //Hay muchos operadores
                    }
                
                    int Right = Integer.parseInt(Pila.pop());       // Saca un valor que es el de la derecha
                    
                    if(Pila.empty()){                           //si la pila despues de esto está vacia tiene muchos signos 
                        return "The expression has too many operators";     //operadores 
                    }
                    int Left = Integer.parseInt(Pila.pop());        //si no está vacia aun se puede sacar otro elemento izquierdo

                    if(Symbol == '+'){      //si es suma se suman y se mete a la pila otra vez
                        int Res = Left + Right;
                        Pila.push(String.valueOf(Res));
                    }
                    if(Symbol == '-'){
                        int Res = Left - Right;
                        Pila.push(String.valueOf(Res));
                    }
                    if(Symbol == '*'){
                        int Res = Left * Right;
                        Pila.push(String.valueOf(Res));
                    }
                    if(Symbol == '/'){
                        int Res = Left * Right;
                        Pila.push(String.valueOf(Res));

                    }
                }
            }
             res = Integer.parseInt(Pila.pop());            // despues de esto el resultado es el que se saque 
             
             if(Pila.empty()){                                      // si la pila esta vacia y solo queda un elemento en la pila
                 return "El resultado es:" + res;                   // esta correcto 
             }
             else{
                 return "Hay un error";                 // si no hay un error 
             }
        }
		
		
	
	
	public static void fibonacci(int n) {
            Queue q = new Queue();
            int a;
            int b;
            q.offer(1);
            q.offer(1);
            
            for(int i=0; i < n; i++){
                a = (int) q.remove();
                b = (int) q.remove();
                
                
                    q.offer(b);
                
                    q.offer(a+b); 
                    
                    System.out.print(a + " ");
            }
        }
        
        public static String convertInfixToPostfix(String expr){
            
            Stack <String> Pila; Pila = new Stack <String>();
            Queue<String> Fila;Fila = new Queue<String>();
            
            Queue<String> Expre;Expre = new Queue <String>();
            
            int start = 0;          //mete la expr a la Expr separada por espacios
            for(int i=0 ;i<expr.length() ;i++){
                char Symbol = expr.charAt(i);
                if(Symbol == ' '){
                    Expre.offer(expr.substring(start, i));
                    start=i+1; 
                }
            }
            expr.substring(start, expr.length());
       return null;
        }
        
        
                
        
    
    public static String reverseParentheses(String expre){
        Stack<Character> pila = new Stack<Character>();
        String Parent = "";
        char Symbol ;
        char current = '0';
        int size = 0;
        for(int i = 0; i < expre.length(); i++){
            Symbol = expre.charAt(i);
            if(Symbol != '('){
                Parent += Symbol;
            }
            else if(Symbol == '('){
                    
                int j = i+1;
                while(current != ')'){
                    pila.push(expre.charAt(j));
                    j++;
                    current = expre.charAt(j);
                }
                current = 0;
                size = pila.size();
                for(int n = 0; n < size; n++){
                    Parent += pila.pop();
                }
                i += size+1;
                
            }    
            
        }
        return Parent;
        }
  
	public static void main(String[] args) {
		System.out.println("Testing balanced symbols");
		System.out.println(checkForBalance("t = arr[3] + a) - 4"));
		System.out.println(checkForBalance("if (arr(3] < 4)"));
		System.out.println(CheckForBalance("System.out.println(std.charAt(3);"));
		System.out.println(CheckForBalance("while (i > 100) { sum += i; i++; }"));
		System.out.println();
		
		System.out.println("Testing postfix evaluation");
		System.out.println("4 3 5 * + => " + postfixEval("4 3 5 * +"));
		System.out.println("1 2 * 3  4 / - => " + postfixEval("1 2 * 3 4 / -"));
		System.out.println("1 2 * 3 * 4 * 5 * 6 * => " + postfixEval("1 2 * 3 * 4 * 5 * 6 *"));
		System.out.println("1 2 3 * 4 + 5 / + => " + postfixEval("1 2 3 * 4 + 5 / +"));
		System.out.println("2 2 * 4 1 * 3 * - 2 1 * / => " + postfixEval("2 2 * 4 1 * 3 * - 2 1 * /"));
		System.out.println("3 8 + * 9 => " + postfixEval("3 8 + * 9"));
		System.out.println("9 8 + 7 => " + postfixEval("9 8 + 7"));
		System.out.println();
		
		System.out.println("Testing Fibonacci sequence");
		fibonacci(5);
		System.out.println();
		
		System.out.println("Testing the Printer class");
		Printer printer = new Printer();
		printer.printDocument("gato.jpg");
		printer.printDocument("tarea.docx");
		printer.printDocument("meme.png");
		try {
			printer.runPrinter();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
                System.out.println("Testing Exam");
		System.out.println(reverseParentheses("a(bc)de"));
		System.out.println();
	}

   

}