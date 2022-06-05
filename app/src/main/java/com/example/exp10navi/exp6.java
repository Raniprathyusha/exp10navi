package com.example.exp10navi;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class exp6 extends AppCompatActivity {

    TextView Num1, Num;
    Button One, two, three, four, five, six, seven, eight, nine, zero,
            add, sub, mul, div, equ, clear, open,close, Dot, clearl,perc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp6);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        open=(Button)findViewById(R.id.Open);
        close=(Button)findViewById(R.id.Closed);
        perc=(Button) findViewById(R.id.dPer);
        One = (Button) findViewById(R.id.b1);
        two = (Button) findViewById(R.id.b2);
        three = (Button) findViewById(R.id.b3);
        four = (Button) findViewById(R.id.b4);
        five = (Button) findViewById(R.id.b5);
        six = (Button) findViewById(R.id.b6);
        seven = (Button) findViewById(R.id.b7);
        eight = (Button) findViewById(R.id.b8);
        nine = (Button) findViewById(R.id.b9);
        zero = (Button) findViewById(R.id.b0);
        add = (Button) findViewById(R.id.bPlus);
        sub = (Button) findViewById(R.id.bSub);
        div = (Button) findViewById(R.id.bDIV);
        mul = (Button) findViewById(R.id.bstar);
        equ = (Button) findViewById(R.id.beq);
        clear = (Button) findViewById(R.id.AC);

        Dot = (Button) findViewById(R.id.bdot);
        Num = (TextView) findViewById(R.id.Tx2);
        Num1 = (TextView) findViewById(R.id.Tx);
        clearl = (Button) findViewById(R.id.clear);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Num.setText(Num.getText()+"(");
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Num.setText(Num.getText()+")");
            }
        });
        clearl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = Num.getText().toString();
                Num.setText("");
                if (str != null && str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                }
                Num.setText(str);
            }
        });
        perc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Num.getText())=="")
                {
                    Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();

                }
                else if (checkbeforeOp(Num.getText().toString())) {
                    Num.setText(Num.getText() + "%");
                } else {
                    Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();
                }
            }
        });
        Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int k=Num.getText().toString().length();
                if((Num.getText())=="")
                {
                    //Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();
                    Num.setText("0"+".");
                }
                else if (((Num.getText().toString()).substring(k-1).equals("+"))||((Num.getText().toString()).substring(k-1).equals("-"))||((Num.getText().toString().substring(k-1)).equals("/")) || ((Num.getText().toString()).substring(k-1).equals("*"))||((Num.getText().toString()).substring(k-1).equals("%")) ) {
                    Num.setText(Num.getText() + "0.");
                    //Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();

                } else {
                    Num.setText(Num.getText() + ".");
                }
            }
        });

        One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num.setText(Num.getText() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num.setText(Num.getText() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num.setText(Num.getText() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num.setText(Num.getText() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num.setText(Num.getText() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num.setText(Num.getText() + "6");

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num.setText(Num.getText() + "7");

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num.setText(Num.getText() + "8");

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num.setText(Num.getText() + "9");

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num.setText(Num.getText() + "0");

            }
        });
        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = Num.getText().toString();
                int k = str.length();
                char[] a1 = str.toCharArray();
                if((Num.getText().toString())=="")
                {
                    Toast.makeText(getApplicationContext(), "Can't Evaluate", Toast.LENGTH_LONG).show();
                }
                else if (a1[k - 1] == '+' || a1[k - 1] == '-' || a1[k - 1] == '*' || a1[k - 1] == '/') {
                    Toast.makeText(getApplicationContext(), "Can't Evaluate", Toast.LENGTH_LONG).show();
                }
                else if((Num.getText().toString().contains("+"))!=true && (Num.getText().toString().contains("-"))!=true && (Num.getText().toString().contains("*"))!=true && (Num.getText().toString().contains("/"))!=true && (Num.getText().toString().contains("%"))!=true )
                {
                    Toast.makeText(getApplicationContext(), "Can't Evaluate", Toast.LENGTH_LONG).show();

                }
                else {
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    //System.out.println(df.format(decimalNumber));
                    //Num1.setText(df.format((calculateExpression(Num.getText().toString()))).toString()+"  ");
                    try {
                        Num1.setText(df.format((calculateExpression(Num.getText().toString()))).toString()+"  ");
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(), "Can't Evaluate", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Num.setText("");
                Num1.setText("");

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Num.getText())=="")
                {
                    Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();

                }
                else if (checkbeforeOp(Num.getText().toString())) {
                    Num.setText(Num.getText() + "+");
                } else {
                    Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Num.getText())=="") {
                    Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();

                }
                else if (checkbeforeOp(Num.getText().toString())) {
                    Num.setText(Num.getText() + "-");
                } else {
                    Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Num.getText())=="") {
                    Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();

                }
                else if (checkbeforeOp(Num.getText().toString())) {
                    Num.setText(Num.getText() + "*");
                } else {
                    Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Num.getText())=="")
                {
                    Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();

                }
                else if (checkbeforeOp(Num.getText().toString())) {
                    Num.setText(Num.getText() + "/");
                } else {
                    Toast.makeText(getApplicationContext(), "enter correct character", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    static boolean checkbeforeOp(String a) {
        int l = a.length();
        char[] a1 = a.toCharArray();
        if (a1[l - 1] != '+' && a1[l - 1] != '-' && a1[l - 1] != '*' && a1[l - 1] != '/') {
            return true;
        } else {
            return false;
        }
    }
    public static Double calculateExpression(String expression) {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int i = 0;
        String currentInteger = null;
        while (i < expression.length()) {
            if ((expression.charAt(i) >= '0' && expression.charAt(i) <= '9')|| expression.charAt(i)=='.') {
                currentInteger = expression.charAt(i) + "";
                i++;
                while (i != expression.length() && ((expression.charAt(i) >= '0' && expression.charAt(i) <= '9')|| expression.charAt(i)=='.')) {
                    currentInteger = currentInteger + expression.charAt(i);
                    i++;
                }
                operandStack.push(Double.parseDouble(currentInteger));
            } else {
                if (expression.charAt(i) == ')')
                {
                    while (operatorStack.peek() != '(')
                    {
                        performArithmeticOperation(operandStack, operatorStack);
                    }
                    operatorStack.pop();
                } else
                {
                    Character currentOperator = expression.charAt(i);
                    Character lastOperator = (operatorStack.isEmpty() ? null : operatorStack.peek());
                    if (lastOperator != null && checkPrecedence(currentOperator, lastOperator)) {
                        performArithmeticOperation(operandStack, operatorStack);
                    }
                    operatorStack.push(expression.charAt(i));
                }
                i++;
            }
        }
        while (!operatorStack.isEmpty()) {
            performArithmeticOperation(operandStack, operatorStack);
        }
        return operandStack.pop();
    }
    public static void performArithmeticOperation(Stack<Double> operandStack, Stack<Character> operatorStack) {
        Double value1 = operandStack.pop();
        Double value2 = operandStack.pop();
        char operator = operatorStack.pop();

        Double intermediateResult = arithmeticOperation(value1, value2, operator);
        operandStack.push(intermediateResult);

    }

    public static boolean checkPrecedence(Character operator1, Character operator2) {

        List<Character> precedenceList = new ArrayList<>();
        precedenceList.add('(');
        precedenceList.add(')');
        precedenceList.add('/');
        precedenceList.add('*');
        precedenceList.add('%');
        precedenceList.add('+');
        precedenceList.add('-');


        if(operator2 == '(' ){
            return false;
        }

        if (precedenceList.indexOf(operator1) > precedenceList.indexOf(operator2)) {
            return true;
        } else {
            return false;
        }

    }

    public static Double arithmeticOperation(Double value2, Double value1, Character operator) {

        Double result;

        switch (operator) {

            case '+':
                result = value1 + value2;
                break;

            case '-':
                result = value1 - value2;
                break;

            case '*':
                result = value1 * value2;
                break;

            case '/':
                result = value1 / value2;
                break;

            case '%':
                result = value1 % value2;
                break;

            default:
                result = value1 + value2;

        }
        return result;
    }
}
