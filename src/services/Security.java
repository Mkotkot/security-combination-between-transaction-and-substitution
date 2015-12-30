/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Kotkot
 */
public class Security extends javax.swing.JFrame {

    CardLayout c;
    int N;
    JTextField ArrTextField[];
    JTextField MYTextField[][];
    char arr2dOneRow[];
    char arr2dTowRowForDecoding[][];
    char ArrRow[];
    char ArrCol[];

    String MyMatrix[][];

    public Security() {

        initComponents();
        c = (CardLayout) p_Working.getLayout();

    }

    public JTextField[] getArrTextFields(JTextField... myArrTextFields) {
        return myArrTextFields;
    }

    public void getMyTextField() {
        MYTextField = new JTextField[N][N];
        ArrTextField = getArrTextFields(X_item00, X_item01, X_item02, X_item03, X_item04, X_item05, X_item06, X_item100, X_item111, X_item122, X_item133, X_item144, X_item155, X_item166, X_item200, X_item211, X_item222, X_item233, X_item244, X_item255, X_item266, X_item300, X_item311, X_item322, X_item333, X_item344, X_item355, X_item366, X_item400, X_item411, X_item422, X_item433, X_item444, X_item455, X_item466, X_item500, X_item511, X_item522, X_item533, X_item544, X_item555, X_item566, X_item500, X_item611, X_item622, X_item633, X_item644, X_item655, X_item666
        );

        JTextField tempArrF[][] = new JTextField[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                tempArrF[i][j] = ArrTextField[j + (i * 7)];
            }
        }
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                MYTextField[i][j] = tempArrF[i][j];
            }

        }
    }

    public String get2CharForChar(char mychar) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < MyMatrix[i][j].length(); k++) {
                    if (MyMatrix[i][j].charAt(k) == mychar) {
                        System.out.print(ArrCol[i] + "-" + ArrRow[j] + "   ");
                        return ArrCol[i] + "" + ArrRow[j] + "";
                    }
                }

            }
        }
        System.out.println("");
        return "";
    }

    public String getAll2DChar(char[] arrPT) {
        String all2dChar = "";

        for (int i = 0; i < arrPT.length; i++) {
            all2dChar = all2dChar + get2CharForChar(arrPT[i]);
        }
        System.out.println("");
        System.out.println("________________________________________________");
        getArrChar2DOneRow(all2dChar);

        return all2dChar;
    }

    public char[] getArrOFPT(String PT) {
        return PT.replace(" ", "").toCharArray();
    }

    public void getArrChar2DOneRow(String Schar2dRow) {
        arr2dOneRow = Schar2dRow.toCharArray();
    }

    public void getArrCharForDecode() {
    }

    public void getArrChar2DTowRowDecode() {
        System.out.println("Top part is Row And Button part Is Colums Decoding ");
        arr2dTowRowForDecoding = new char[2][arr2dOneRow.length / 2];
        System.out.println("-- " + arr2dOneRow.length);
        int x = 0;
        for (int i = 0; i < arr2dOneRow.length; i++) {
            if (i % 2 == 0) {
                arr2dTowRowForDecoding[0][x] = arr2dOneRow[i];

            } else {
                arr2dTowRowForDecoding[1][x] = arr2dOneRow[i];
                x++;
            }
        }
//

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < arr2dTowRowForDecoding[0].length; j++) {
                System.out.print(arr2dTowRowForDecoding[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("____________________________________________");

        for (int i = 0; i < arr2dOneRow.length / 2; i++) {
            arr2dOneRow[i] = arr2dTowRowForDecoding[0][i];
        }
        for (int i = 0; i < arr2dOneRow.length / 2; i++) {
            arr2dOneRow[i + (arr2dOneRow.length / 2)] = arr2dTowRowForDecoding[1][i];
        }

        System.out.println("");
        System.out.println("__________________________________________");
        for (int i = 0; i < arr2dOneRow.length; i++) {
            System.out.print("-" + arr2dOneRow[i] + "  ");
        }
        
        int xx = 0; 
        for (int i = 0; i < arr2dOneRow.length; i++) {
            
            if (i % 2 == 0) {
                arr2dTowRowForDecoding[0][xx] = arr2dOneRow[i];

            } else {
                arr2dTowRowForDecoding[1][xx] = arr2dOneRow[i];
                xx++;
            }
        
        }
        
        System.out.println("_________________ ___________________________");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < arr2dTowRowForDecoding[0].length; j++) {
                System.out.print(arr2dTowRowForDecoding[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("_____________________ _______________________");
         

    }

    public String GetCTDEcryprion() {
        String MyCt = "";
        String temp = "";
        for (int i = 0; i < arr2dOneRow.length / 2; i++) {
            temp = MyMatrix[get_indexof_char(arr2dTowRowForDecoding[0][i], ArrCol)][get_indexof_char(arr2dTowRowForDecoding[1][i], ArrCol)];
            if (temp.length() == 1) {
                MyCt = MyCt + temp;
                temp = "";
            } else {
                temp = "(" + temp + ")";
                MyCt = MyCt + temp;
                temp = "";
            }
        }
        System.out.println("");
        System.out.println("_____________________________________________");

        System.out.println("My Cipher Text is :-");
        System.out.println(MyCt);
        return MyCt;
    }

    public int get_indexof_char(char c, char[] myArr) {
        int i;
        for (i = 0; i < myArr.length; i++) {
            if (c == myArr[i]) {
                break;
            }
        }
        return i;
    }

    public void setBackGround() {
        if (N == 3) {
            X_item300.setBackground(new Color(255, 255, 255));
            X_item300.setEditable(true);
            X_item311.setBackground(new Color(255, 255, 255));
            X_item311.setEditable(true);
            X_item322.setBackground(new Color(255, 255, 255));
            X_item322.setEditable(true);
            X_item333.setBackground(new Color(255, 255, 255));
            X_item333.setEditable(true);
            X_item344.setBackground(new Color(255, 255, 255));
            X_item344.setEditable(true);
            X_item355.setBackground(new Color(255, 255, 255));
            X_item355.setEditable(true);
            X_item366.setBackground(new Color(255, 255, 255));
            X_item366.setEditable(true);

            X_item400.setBackground(new Color(255, 255, 255));
            X_item400.setEditable(true);
            X_item411.setBackground(new Color(255, 255, 255));
            X_item411.setEditable(true);
            X_item422.setBackground(new Color(255, 255, 255));
            X_item422.setEditable(true);
            X_item433.setBackground(new Color(255, 255, 255));
            X_item433.setEditable(true);
            X_item444.setBackground(new Color(255, 255, 255));
            X_item444.setEditable(true);
            X_item455.setBackground(new Color(255, 255, 255));
            X_item455.setEditable(true);
            X_item466.setBackground(new Color(255, 255, 255));
            X_item466.setEditable(true);

            X_item500.setBackground(new Color(255, 255, 255));
            X_item500.setEditable(true);
            X_item511.setBackground(new Color(255, 255, 255));
            X_item511.setEditable(true);
            X_item522.setBackground(new Color(255, 255, 255));
            X_item522.setEditable(true);
            X_item533.setBackground(new Color(255, 255, 255));
            X_item533.setEditable(true);
            X_item544.setBackground(new Color(255, 255, 255));
            X_item544.setEditable(true);
            X_item555.setBackground(new Color(255, 255, 255));
            X_item555.setEditable(true);
            X_item566.setBackground(new Color(255, 255, 255));
            X_item566.setEditable(true);

            X_item600.setBackground(new Color(255, 255, 255));
            X_item600.setEditable(true);
            X_item611.setBackground(new Color(255, 255, 255));
            X_item611.setEditable(true);
            X_item622.setBackground(new Color(255, 255, 255));
            X_item622.setEditable(true);
            X_item633.setBackground(new Color(255, 255, 255));
            X_item633.setEditable(true);
            X_item644.setBackground(new Color(255, 255, 255));
            X_item644.setEditable(true);
            X_item655.setBackground(new Color(255, 255, 255));
            X_item655.setEditable(true);
            X_item666.setBackground(new Color(255, 255, 255));
            X_item666.setEditable(true);

            ///////////
            X_item03.setBackground(new Color(255, 255, 255));
            X_item03.setEditable(true);
            X_item133.setBackground(new Color(255, 255, 255));
            X_item133.setEditable(true);
            X_item233.setBackground(new Color(255, 255, 255));
            X_item233.setEditable(true);
            X_item333.setBackground(new Color(255, 255, 255));
            X_item333.setEditable(true);
            X_item433.setBackground(new Color(255, 255, 255));
            X_item433.setEditable(true);
            X_item533.setBackground(new Color(255, 255, 255));
            X_item533.setEditable(true);
            X_item633.setBackground(new Color(255, 255, 255));
            X_item633.setEditable(true);

            X_item04.setBackground(new Color(255, 255, 255));
            X_item04.setEditable(true);
            X_item144.setBackground(new Color(255, 255, 255));
            X_item144.setEditable(true);
            X_item244.setBackground(new Color(255, 255, 255));
            X_item244.setEditable(true);
            X_item344.setBackground(new Color(255, 255, 255));
            X_item344.setEditable(true);
            X_item444.setBackground(new Color(255, 255, 255));
            X_item444.setEditable(true);
            X_item544.setBackground(new Color(255, 255, 255));
            X_item544.setEditable(true);
            X_item644.setBackground(new Color(255, 255, 255));
            X_item644.setEditable(true);

            X_item05.setBackground(new Color(255, 255, 255));
            X_item05.setEditable(true);
            X_item155.setBackground(new Color(255, 255, 255));
            X_item155.setEditable(true);
            X_item255.setBackground(new Color(255, 255, 255));
            X_item255.setEditable(true);
            X_item355.setBackground(new Color(255, 255, 255));
            X_item355.setEditable(true);
            X_item455.setBackground(new Color(255, 255, 255));
            X_item455.setEditable(true);
            X_item555.setBackground(new Color(255, 255, 255));
            X_item555.setEditable(true);
            X_item655.setBackground(new Color(255, 255, 255));
            X_item655.setEditable(true);

            X_item06.setBackground(new Color(255, 255, 255));
            X_item06.setEditable(true);
            X_item166.setBackground(new Color(255, 255, 255));
            X_item166.setEditable(true);
            X_item266.setBackground(new Color(255, 255, 255));
            X_item266.setEditable(true);
            X_item366.setBackground(new Color(255, 255, 255));
            X_item366.setEditable(true);
            X_item466.setBackground(new Color(255, 255, 255));
            X_item466.setEditable(true);
            X_item566.setBackground(new Color(255, 255, 255));
            X_item566.setEditable(true);
            X_item666.setBackground(new Color(255, 255, 255));
            X_item666.setEditable(true);

            ///***
            X_item03.setBackground(new Color(0, 102, 102));
            X_item03.setEditable(false);
            X_item133.setBackground(new Color(0, 102, 102));
            X_item133.setEditable(false);
            X_item233.setBackground(new Color(0, 102, 102));
            X_item233.setEditable(false);
            X_item333.setBackground(new Color(0, 102, 102));
            X_item333.setEditable(false);

            X_item04.setBackground(new Color(0, 102, 102));
            X_item04.setEditable(false);
            X_item144.setBackground(new Color(0, 102, 102));
            X_item144.setEditable(false);
            X_item244.setBackground(new Color(0, 102, 102));
            X_item244.setEditable(false);
            X_item344.setBackground(new Color(0, 102, 102));
            X_item344.setEditable(false);

            X_item05.setBackground(new Color(0, 102, 102));
            X_item05.setEditable(false);
            X_item155.setBackground(new Color(0, 102, 102));
            X_item155.setEditable(false);
            X_item255.setBackground(new Color(0, 102, 102));
            X_item255.setEditable(false);
            X_item355.setBackground(new Color(0, 102, 102));
            X_item355.setEditable(false);

            X_item06.setBackground(new Color(0, 102, 102));
            X_item06.setEditable(false);
            X_item166.setBackground(new Color(0, 102, 102));
            X_item166.setEditable(false);
            X_item266.setBackground(new Color(0, 102, 102));
            X_item266.setEditable(false);
            X_item366.setBackground(new Color(0, 102, 102));
            X_item366.setEditable(false);

            X_item300.setBackground(new Color(0, 102, 102));
            X_item300.setEditable(false);
            X_item311.setBackground(new Color(0, 102, 102));
            X_item311.setEditable(false);
            X_item322.setBackground(new Color(0, 102, 102));
            X_item322.setEditable(false);
            X_item333.setBackground(new Color(0, 102, 102));
            X_item333.setEditable(false);
            X_item344.setBackground(new Color(0, 102, 102));
            X_item344.setEditable(false);
            X_item355.setBackground(new Color(0, 102, 102));
            X_item355.setEditable(false);
            X_item366.setBackground(new Color(0, 102, 102));
            X_item366.setEditable(false);

            X_item400.setBackground(new Color(0, 102, 102));
            X_item400.setEditable(false);
            X_item411.setBackground(new Color(0, 102, 102));
            X_item411.setEditable(false);
            X_item422.setBackground(new Color(0, 102, 102));
            X_item422.setEditable(false);
            X_item433.setBackground(new Color(0, 102, 102));
            X_item433.setEditable(false);
            X_item444.setBackground(new Color(0, 102, 102));
            X_item444.setEditable(false);
            X_item455.setBackground(new Color(0, 102, 102));
            X_item455.setEditable(false);
            X_item466.setBackground(new Color(0, 102, 102));
            X_item466.setEditable(false);

            X_item500.setBackground(new Color(0, 102, 102));
            X_item500.setEditable(false);
            X_item511.setBackground(new Color(0, 102, 102));
            X_item511.setEditable(false);
            X_item522.setBackground(new Color(0, 102, 102));
            X_item522.setEditable(false);
            X_item533.setBackground(new Color(0, 102, 102));
            X_item533.setEditable(false);
            X_item544.setBackground(new Color(0, 102, 102));
            X_item544.setEditable(false);
            X_item555.setBackground(new Color(0, 102, 102));
            X_item555.setEditable(false);
            X_item566.setBackground(new Color(0, 102, 102));
            X_item566.setEditable(false);

            X_item600.setBackground(new Color(0, 102, 102));
            X_item600.setEditable(false);
            X_item611.setBackground(new Color(0, 102, 102));
            X_item611.setEditable(false);
            X_item622.setBackground(new Color(0, 102, 102));
            X_item622.setEditable(false);
            X_item633.setBackground(new Color(0, 102, 102));
            X_item633.setEditable(false);
            X_item644.setBackground(new Color(0, 102, 102));
            X_item644.setEditable(false);
            X_item655.setBackground(new Color(0, 102, 102));
            X_item655.setEditable(false);
            X_item666.setBackground(new Color(0, 102, 102));
            X_item666.setEditable(false);

        } else if (N == 4) {

            X_item300.setBackground(new Color(255, 255, 255));
            X_item300.setEditable(true);
            X_item311.setBackground(new Color(255, 255, 255));
            X_item311.setEditable(true);
            X_item322.setBackground(new Color(255, 255, 255));
            X_item322.setEditable(true);
            X_item333.setBackground(new Color(255, 255, 255));
            X_item333.setEditable(true);
            X_item344.setBackground(new Color(255, 255, 255));
            X_item344.setEditable(true);
            X_item355.setBackground(new Color(255, 255, 255));
            X_item355.setEditable(true);
            X_item366.setBackground(new Color(255, 255, 255));
            X_item366.setEditable(true);

            X_item400.setBackground(new Color(255, 255, 255));
            X_item400.setEditable(true);
            X_item411.setBackground(new Color(255, 255, 255));
            X_item411.setEditable(true);
            X_item422.setBackground(new Color(255, 255, 255));
            X_item422.setEditable(true);
            X_item433.setBackground(new Color(255, 255, 255));
            X_item433.setEditable(true);
            X_item444.setBackground(new Color(255, 255, 255));
            X_item444.setEditable(true);
            X_item455.setBackground(new Color(255, 255, 255));
            X_item455.setEditable(true);
            X_item466.setBackground(new Color(255, 255, 255));
            X_item466.setEditable(true);

            X_item500.setBackground(new Color(255, 255, 255));
            X_item500.setEditable(true);
            X_item511.setBackground(new Color(255, 255, 255));
            X_item511.setEditable(true);
            X_item522.setBackground(new Color(255, 255, 255));
            X_item522.setEditable(true);
            X_item533.setBackground(new Color(255, 255, 255));
            X_item533.setEditable(true);
            X_item544.setBackground(new Color(255, 255, 255));
            X_item544.setEditable(true);
            X_item555.setBackground(new Color(255, 255, 255));
            X_item555.setEditable(true);
            X_item566.setBackground(new Color(255, 255, 255));
            X_item566.setEditable(true);

            X_item600.setBackground(new Color(255, 255, 255));
            X_item600.setEditable(true);
            X_item611.setBackground(new Color(255, 255, 255));
            X_item611.setEditable(true);
            X_item622.setBackground(new Color(255, 255, 255));
            X_item622.setEditable(true);
            X_item633.setBackground(new Color(255, 255, 255));
            X_item633.setEditable(true);
            X_item644.setBackground(new Color(255, 255, 255));
            X_item644.setEditable(true);
            X_item655.setBackground(new Color(255, 255, 255));
            X_item655.setEditable(true);
            X_item666.setBackground(new Color(255, 255, 255));
            X_item666.setEditable(true);

            ///////////
            X_item03.setBackground(new Color(255, 255, 255));
            X_item03.setEditable(true);
            X_item133.setBackground(new Color(255, 255, 255));
            X_item133.setEditable(true);
            X_item233.setBackground(new Color(255, 255, 255));
            X_item233.setEditable(true);
            X_item333.setBackground(new Color(255, 255, 255));
            X_item333.setEditable(true);
            X_item433.setBackground(new Color(255, 255, 255));
            X_item433.setEditable(true);
            X_item533.setBackground(new Color(255, 255, 255));
            X_item533.setEditable(true);
            X_item633.setBackground(new Color(255, 255, 255));
            X_item633.setEditable(true);

            X_item04.setBackground(new Color(255, 255, 255));
            X_item04.setEditable(true);
            X_item144.setBackground(new Color(255, 255, 255));
            X_item144.setEditable(true);
            X_item244.setBackground(new Color(255, 255, 255));
            X_item244.setEditable(true);
            X_item344.setBackground(new Color(255, 255, 255));
            X_item344.setEditable(true);
            X_item444.setBackground(new Color(255, 255, 255));
            X_item444.setEditable(true);
            X_item544.setBackground(new Color(255, 255, 255));
            X_item544.setEditable(true);
            X_item644.setBackground(new Color(255, 255, 255));
            X_item644.setEditable(true);

            X_item05.setBackground(new Color(255, 255, 255));
            X_item05.setEditable(true);
            X_item155.setBackground(new Color(255, 255, 255));
            X_item155.setEditable(true);
            X_item255.setBackground(new Color(255, 255, 255));
            X_item255.setEditable(true);
            X_item355.setBackground(new Color(255, 255, 255));
            X_item355.setEditable(true);
            X_item455.setBackground(new Color(255, 255, 255));
            X_item455.setEditable(true);
            X_item555.setBackground(new Color(255, 255, 255));
            X_item555.setEditable(true);
            X_item655.setBackground(new Color(255, 255, 255));
            X_item655.setEditable(true);

            X_item06.setBackground(new Color(255, 255, 255));
            X_item06.setEditable(true);
            X_item166.setBackground(new Color(255, 255, 255));
            X_item166.setEditable(true);
            X_item266.setBackground(new Color(255, 255, 255));
            X_item266.setEditable(true);
            X_item366.setBackground(new Color(255, 255, 255));
            X_item366.setEditable(true);
            X_item466.setBackground(new Color(255, 255, 255));
            X_item466.setEditable(true);
            X_item566.setBackground(new Color(255, 255, 255));
            X_item566.setEditable(true);
            X_item666.setBackground(new Color(255, 255, 255));
            X_item666.setEditable(true);

            ///***
            X_item04.setBackground(new Color(0, 102, 102));
            X_item04.setEditable(false);
            X_item144.setBackground(new Color(0, 102, 102));
            X_item144.setEditable(false);
            X_item244.setBackground(new Color(0, 102, 102));
            X_item244.setEditable(false);
            X_item344.setBackground(new Color(0, 102, 102));
            X_item344.setEditable(false);

            X_item05.setBackground(new Color(0, 102, 102));
            X_item05.setEditable(false);
            X_item155.setBackground(new Color(0, 102, 102));
            X_item155.setEditable(false);
            X_item255.setBackground(new Color(0, 102, 102));
            X_item255.setEditable(false);
            X_item355.setBackground(new Color(0, 102, 102));
            X_item355.setEditable(false);

            X_item06.setBackground(new Color(0, 102, 102));
            X_item06.setEditable(false);
            X_item166.setBackground(new Color(0, 102, 102));
            X_item166.setEditable(false);
            X_item266.setBackground(new Color(0, 102, 102));
            X_item266.setEditable(false);
            X_item366.setBackground(new Color(0, 102, 102));
            X_item366.setEditable(false);

            X_item400.setBackground(new Color(0, 102, 102));
            X_item400.setEditable(false);
            X_item411.setBackground(new Color(0, 102, 102));
            X_item411.setEditable(false);
            X_item422.setBackground(new Color(0, 102, 102));
            X_item422.setEditable(false);
            X_item433.setBackground(new Color(0, 102, 102));
            X_item433.setEditable(false);
            X_item444.setBackground(new Color(0, 102, 102));
            X_item444.setEditable(false);
            X_item455.setBackground(new Color(0, 102, 102));
            X_item455.setEditable(false);
            X_item466.setBackground(new Color(0, 102, 102));
            X_item466.setEditable(false);

            X_item500.setBackground(new Color(0, 102, 102));
            X_item500.setEditable(false);
            X_item511.setBackground(new Color(0, 102, 102));
            X_item511.setEditable(false);
            X_item522.setBackground(new Color(0, 102, 102));
            X_item522.setEditable(false);
            X_item533.setBackground(new Color(0, 102, 102));
            X_item533.setEditable(false);
            X_item544.setBackground(new Color(0, 102, 102));
            X_item544.setEditable(false);
            X_item555.setBackground(new Color(0, 102, 102));
            X_item555.setEditable(false);
            X_item566.setBackground(new Color(0, 102, 102));
            X_item566.setEditable(false);

            X_item600.setBackground(new Color(0, 102, 102));
            X_item600.setEditable(false);
            X_item611.setBackground(new Color(0, 102, 102));
            X_item611.setEditable(false);
            X_item622.setBackground(new Color(0, 102, 102));
            X_item622.setEditable(false);
            X_item633.setBackground(new Color(0, 102, 102));
            X_item633.setEditable(false);
            X_item644.setBackground(new Color(0, 102, 102));
            X_item644.setEditable(false);
            X_item655.setBackground(new Color(0, 102, 102));
            X_item655.setEditable(false);
            X_item666.setBackground(new Color(0, 102, 102));
            X_item666.setEditable(false);

        } else if (N == 5) {

            X_item300.setBackground(new Color(255, 255, 255));
            X_item300.setEditable(true);
            X_item311.setBackground(new Color(255, 255, 255));
            X_item311.setEditable(true);
            X_item322.setBackground(new Color(255, 255, 255));
            X_item322.setEditable(true);
            X_item333.setBackground(new Color(255, 255, 255));
            X_item333.setEditable(true);
            X_item344.setBackground(new Color(255, 255, 255));
            X_item344.setEditable(true);
            X_item355.setBackground(new Color(255, 255, 255));
            X_item355.setEditable(true);
            X_item366.setBackground(new Color(255, 255, 255));
            X_item366.setEditable(true);

            X_item400.setBackground(new Color(255, 255, 255));
            X_item400.setEditable(true);
            X_item411.setBackground(new Color(255, 255, 255));
            X_item411.setEditable(true);
            X_item422.setBackground(new Color(255, 255, 255));
            X_item422.setEditable(true);
            X_item433.setBackground(new Color(255, 255, 255));
            X_item433.setEditable(true);
            X_item444.setBackground(new Color(255, 255, 255));
            X_item444.setEditable(true);
            X_item455.setBackground(new Color(255, 255, 255));
            X_item455.setEditable(true);
            X_item466.setBackground(new Color(255, 255, 255));
            X_item466.setEditable(true);

            X_item500.setBackground(new Color(255, 255, 255));
            X_item500.setEditable(true);
            X_item511.setBackground(new Color(255, 255, 255));
            X_item511.setEditable(true);
            X_item522.setBackground(new Color(255, 255, 255));
            X_item522.setEditable(true);
            X_item533.setBackground(new Color(255, 255, 255));
            X_item533.setEditable(true);
            X_item544.setBackground(new Color(255, 255, 255));
            X_item544.setEditable(true);
            X_item555.setBackground(new Color(255, 255, 255));
            X_item555.setEditable(true);
            X_item566.setBackground(new Color(255, 255, 255));
            X_item566.setEditable(true);

            X_item600.setBackground(new Color(255, 255, 255));
            X_item600.setEditable(true);
            X_item611.setBackground(new Color(255, 255, 255));
            X_item611.setEditable(true);
            X_item622.setBackground(new Color(255, 255, 255));
            X_item622.setEditable(true);
            X_item633.setBackground(new Color(255, 255, 255));
            X_item633.setEditable(true);
            X_item644.setBackground(new Color(255, 255, 255));
            X_item644.setEditable(true);
            X_item655.setBackground(new Color(255, 255, 255));
            X_item655.setEditable(true);
            X_item666.setBackground(new Color(255, 255, 255));
            X_item666.setEditable(true);

            ///////////
            X_item03.setBackground(new Color(255, 255, 255));
            X_item03.setEditable(true);
            X_item133.setBackground(new Color(255, 255, 255));
            X_item133.setEditable(true);
            X_item233.setBackground(new Color(255, 255, 255));
            X_item233.setEditable(true);
            X_item333.setBackground(new Color(255, 255, 255));
            X_item333.setEditable(true);
            X_item433.setBackground(new Color(255, 255, 255));
            X_item433.setEditable(true);
            X_item533.setBackground(new Color(255, 255, 255));
            X_item533.setEditable(true);
            X_item633.setBackground(new Color(255, 255, 255));
            X_item633.setEditable(true);

            X_item04.setBackground(new Color(255, 255, 255));
            X_item04.setEditable(true);
            X_item144.setBackground(new Color(255, 255, 255));
            X_item144.setEditable(true);
            X_item244.setBackground(new Color(255, 255, 255));
            X_item244.setEditable(true);
            X_item344.setBackground(new Color(255, 255, 255));
            X_item344.setEditable(true);
            X_item444.setBackground(new Color(255, 255, 255));
            X_item444.setEditable(true);
            X_item544.setBackground(new Color(255, 255, 255));
            X_item544.setEditable(true);
            X_item644.setBackground(new Color(255, 255, 255));
            X_item644.setEditable(true);

            X_item05.setBackground(new Color(255, 255, 255));
            X_item05.setEditable(true);
            X_item155.setBackground(new Color(255, 255, 255));
            X_item155.setEditable(true);
            X_item255.setBackground(new Color(255, 255, 255));
            X_item255.setEditable(true);
            X_item355.setBackground(new Color(255, 255, 255));
            X_item355.setEditable(true);
            X_item455.setBackground(new Color(255, 255, 255));
            X_item455.setEditable(true);
            X_item555.setBackground(new Color(255, 255, 255));
            X_item555.setEditable(true);
            X_item655.setBackground(new Color(255, 255, 255));
            X_item655.setEditable(true);

            X_item06.setBackground(new Color(255, 255, 255));
            X_item06.setEditable(true);
            X_item166.setBackground(new Color(255, 255, 255));
            X_item166.setEditable(true);
            X_item266.setBackground(new Color(255, 255, 255));
            X_item266.setEditable(true);
            X_item366.setBackground(new Color(255, 255, 255));
            X_item366.setEditable(true);
            X_item466.setBackground(new Color(255, 255, 255));
            X_item466.setEditable(true);
            X_item566.setBackground(new Color(255, 255, 255));
            X_item566.setEditable(true);
            X_item666.setBackground(new Color(255, 255, 255));
            X_item666.setEditable(true);

            ///***
            X_item05.setBackground(new Color(0, 102, 102));
            X_item05.setEditable(false);
            X_item155.setBackground(new Color(0, 102, 102));
            X_item155.setEditable(false);
            X_item255.setBackground(new Color(0, 102, 102));
            X_item255.setEditable(false);
            X_item355.setBackground(new Color(0, 102, 102));
            X_item355.setEditable(false);
            X_item455.setBackground(new Color(0, 102, 102));
            X_item455.setEditable(false);
            X_item555.setBackground(new Color(0, 102, 102));
            X_item555.setEditable(false);
            X_item655.setBackground(new Color(0, 102, 102));
            X_item655.setEditable(false);

            X_item06.setBackground(new Color(0, 102, 102));
            X_item06.setEditable(false);
            X_item166.setBackground(new Color(0, 102, 102));
            X_item166.setEditable(false);
            X_item266.setBackground(new Color(0, 102, 102));
            X_item266.setEditable(false);
            X_item366.setBackground(new Color(0, 102, 102));
            X_item366.setEditable(false);
            X_item466.setBackground(new Color(0, 102, 102));
            X_item466.setEditable(false);
            X_item566.setBackground(new Color(0, 102, 102));
            X_item566.setEditable(false);
            X_item666.setBackground(new Color(0, 102, 102));
            X_item666.setEditable(false);

            /////////////
            X_item500.setBackground(new Color(0, 102, 102));
            X_item500.setEditable(false);
            X_item511.setBackground(new Color(0, 102, 102));
            X_item511.setEditable(false);
            X_item522.setBackground(new Color(0, 102, 102));
            X_item522.setEditable(false);
            X_item533.setBackground(new Color(0, 102, 102));
            X_item533.setEditable(false);
            X_item544.setBackground(new Color(0, 102, 102));
            X_item544.setEditable(false);
            X_item555.setBackground(new Color(0, 102, 102));
            X_item555.setEditable(false);
            X_item566.setBackground(new Color(0, 102, 102));
            X_item566.setEditable(false);

            X_item600.setBackground(new Color(0, 102, 102));
            X_item600.setEditable(false);
            X_item611.setBackground(new Color(0, 102, 102));
            X_item611.setEditable(false);
            X_item622.setBackground(new Color(0, 102, 102));
            X_item622.setEditable(false);
            X_item633.setBackground(new Color(0, 102, 102));
            X_item633.setEditable(false);
            X_item644.setBackground(new Color(0, 102, 102));
            X_item644.setEditable(false);
            X_item655.setBackground(new Color(0, 102, 102));
            X_item655.setEditable(false);
            X_item666.setBackground(new Color(0, 102, 102));
            X_item666.setEditable(false);

        } else if (N == 6) {

            X_item300.setBackground(new Color(255, 255, 255));
            X_item300.setEditable(true);
            X_item311.setBackground(new Color(255, 255, 255));
            X_item311.setEditable(true);
            X_item322.setBackground(new Color(255, 255, 255));
            X_item322.setEditable(true);
            X_item333.setBackground(new Color(255, 255, 255));
            X_item333.setEditable(true);
            X_item344.setBackground(new Color(255, 255, 255));
            X_item344.setEditable(true);
            X_item355.setBackground(new Color(255, 255, 255));
            X_item355.setEditable(true);
            X_item366.setBackground(new Color(255, 255, 255));
            X_item366.setEditable(true);

            X_item400.setBackground(new Color(255, 255, 255));
            X_item400.setEditable(true);
            X_item411.setBackground(new Color(255, 255, 255));
            X_item411.setEditable(true);
            X_item422.setBackground(new Color(255, 255, 255));
            X_item422.setEditable(true);
            X_item433.setBackground(new Color(255, 255, 255));
            X_item433.setEditable(true);
            X_item444.setBackground(new Color(255, 255, 255));
            X_item444.setEditable(true);
            X_item455.setBackground(new Color(255, 255, 255));
            X_item455.setEditable(true);
            X_item466.setBackground(new Color(255, 255, 255));
            X_item466.setEditable(true);

            X_item500.setBackground(new Color(255, 255, 255));
            X_item500.setEditable(true);
            X_item511.setBackground(new Color(255, 255, 255));
            X_item511.setEditable(true);
            X_item522.setBackground(new Color(255, 255, 255));
            X_item522.setEditable(true);
            X_item533.setBackground(new Color(255, 255, 255));
            X_item533.setEditable(true);
            X_item544.setBackground(new Color(255, 255, 255));
            X_item544.setEditable(true);
            X_item555.setBackground(new Color(255, 255, 255));
            X_item555.setEditable(true);
            X_item566.setBackground(new Color(255, 255, 255));
            X_item566.setEditable(true);

            X_item600.setBackground(new Color(255, 255, 255));
            X_item600.setEditable(true);
            X_item611.setBackground(new Color(255, 255, 255));
            X_item611.setEditable(true);
            X_item622.setBackground(new Color(255, 255, 255));
            X_item622.setEditable(true);
            X_item633.setBackground(new Color(255, 255, 255));
            X_item633.setEditable(true);
            X_item644.setBackground(new Color(255, 255, 255));
            X_item644.setEditable(true);
            X_item655.setBackground(new Color(255, 255, 255));
            X_item655.setEditable(true);
            X_item666.setBackground(new Color(255, 255, 255));
            X_item666.setEditable(true);

            ///////////
            X_item03.setBackground(new Color(255, 255, 255));
            X_item03.setEditable(true);
            X_item133.setBackground(new Color(255, 255, 255));
            X_item133.setEditable(true);
            X_item233.setBackground(new Color(255, 255, 255));
            X_item233.setEditable(true);
            X_item333.setBackground(new Color(255, 255, 255));
            X_item333.setEditable(true);
            X_item433.setBackground(new Color(255, 255, 255));
            X_item433.setEditable(true);
            X_item533.setBackground(new Color(255, 255, 255));
            X_item533.setEditable(true);
            X_item633.setBackground(new Color(255, 255, 255));
            X_item633.setEditable(true);

            X_item04.setBackground(new Color(255, 255, 255));
            X_item04.setEditable(true);
            X_item144.setBackground(new Color(255, 255, 255));
            X_item144.setEditable(true);
            X_item244.setBackground(new Color(255, 255, 255));
            X_item244.setEditable(true);
            X_item344.setBackground(new Color(255, 255, 255));
            X_item344.setEditable(true);
            X_item444.setBackground(new Color(255, 255, 255));
            X_item444.setEditable(true);
            X_item544.setBackground(new Color(255, 255, 255));
            X_item544.setEditable(true);
            X_item644.setBackground(new Color(255, 255, 255));
            X_item644.setEditable(true);

            X_item05.setBackground(new Color(255, 255, 255));
            X_item05.setEditable(true);
            X_item155.setBackground(new Color(255, 255, 255));
            X_item155.setEditable(true);
            X_item255.setBackground(new Color(255, 255, 255));
            X_item255.setEditable(true);
            X_item355.setBackground(new Color(255, 255, 255));
            X_item355.setEditable(true);
            X_item455.setBackground(new Color(255, 255, 255));
            X_item455.setEditable(true);
            X_item555.setBackground(new Color(255, 255, 255));
            X_item555.setEditable(true);
            X_item655.setBackground(new Color(255, 255, 255));
            X_item655.setEditable(true);

            X_item06.setBackground(new Color(255, 255, 255));
            X_item06.setEditable(true);
            X_item166.setBackground(new Color(255, 255, 255));
            X_item166.setEditable(true);
            X_item266.setBackground(new Color(255, 255, 255));
            X_item266.setEditable(true);
            X_item366.setBackground(new Color(255, 255, 255));
            X_item366.setEditable(true);
            X_item466.setBackground(new Color(255, 255, 255));
            X_item466.setEditable(true);
            X_item566.setBackground(new Color(255, 255, 255));
            X_item566.setEditable(true);
            X_item666.setBackground(new Color(255, 255, 255));
            X_item666.setEditable(true);

            ///***
            X_item06.setBackground(new Color(0, 102, 102));
            X_item06.setEditable(false);
            X_item166.setBackground(new Color(0, 102, 102));
            X_item166.setEditable(false);
            X_item266.setBackground(new Color(0, 102, 102));
            X_item266.setEditable(false);
            X_item366.setBackground(new Color(0, 102, 102));
            X_item366.setEditable(false);
            X_item466.setBackground(new Color(0, 102, 102));
            X_item466.setEditable(false);
            X_item566.setBackground(new Color(0, 102, 102));
            X_item566.setEditable(false);
            X_item666.setBackground(new Color(0, 102, 102));
            X_item666.setEditable(false);

            ////////////// 
            X_item600.setBackground(new Color(0, 102, 102));
            X_item600.setEditable(false);
            X_item611.setBackground(new Color(0, 102, 102));
            X_item611.setEditable(false);
            X_item622.setBackground(new Color(0, 102, 102));
            X_item622.setEditable(false);
            X_item633.setBackground(new Color(0, 102, 102));
            X_item633.setEditable(false);
            X_item644.setBackground(new Color(0, 102, 102));
            X_item644.setEditable(false);
            X_item655.setBackground(new Color(0, 102, 102));
            X_item655.setEditable(false);
            X_item666.setBackground(new Color(0, 102, 102));
            X_item666.setEditable(false);

        } else if (N == 7) {
            X_item03.setBackground(new Color(255, 255, 255));
            X_item03.setEditable(true);
            X_item133.setBackground(new Color(255, 255, 255));
            X_item133.setEditable(true);
            X_item233.setBackground(new Color(255, 255, 255));
            X_item233.setEditable(true);
            X_item333.setBackground(new Color(255, 255, 255));
            X_item333.setEditable(true);

            X_item04.setBackground(new Color(255, 255, 255));
            X_item04.setEditable(true);
            X_item144.setBackground(new Color(255, 255, 255));
            X_item144.setEditable(true);
            X_item244.setBackground(new Color(255, 255, 255));
            X_item244.setEditable(true);
            X_item344.setBackground(new Color(255, 255, 255));
            X_item344.setEditable(true);

            X_item05.setBackground(new Color(255, 255, 255));
            X_item05.setEditable(true);
            X_item155.setBackground(new Color(255, 255, 255));
            X_item155.setEditable(true);
            X_item255.setBackground(new Color(255, 255, 255));
            X_item255.setEditable(true);
            X_item355.setBackground(new Color(255, 255, 255));
            X_item355.setEditable(true);

            X_item06.setBackground(new Color(255, 255, 255));
            X_item06.setEditable(true);
            X_item166.setBackground(new Color(255, 255, 255));
            X_item166.setEditable(true);
            X_item266.setBackground(new Color(255, 255, 255));
            X_item266.setEditable(true);
            X_item366.setBackground(new Color(255, 255, 255));
            X_item366.setEditable(true);

            X_item300.setBackground(new Color(255, 255, 255));
            X_item300.setEditable(true);
            X_item311.setBackground(new Color(255, 255, 255));
            X_item311.setEditable(true);
            X_item322.setBackground(new Color(255, 255, 255));
            X_item322.setEditable(true);
            X_item333.setBackground(new Color(255, 255, 255));
            X_item333.setEditable(true);
            X_item344.setBackground(new Color(255, 255, 255));
            X_item344.setEditable(true);
            X_item355.setBackground(new Color(255, 255, 255));
            X_item355.setEditable(true);
            X_item366.setBackground(new Color(255, 255, 255));
            X_item366.setEditable(true);

            X_item400.setBackground(new Color(255, 255, 255));
            X_item400.setEditable(true);
            X_item411.setBackground(new Color(255, 255, 255));
            X_item411.setEditable(true);
            X_item422.setBackground(new Color(255, 255, 255));
            X_item422.setEditable(true);
            X_item433.setBackground(new Color(255, 255, 255));
            X_item433.setEditable(true);
            X_item444.setBackground(new Color(255, 255, 255));
            X_item444.setEditable(true);
            X_item455.setBackground(new Color(255, 255, 255));
            X_item455.setEditable(true);
            X_item466.setBackground(new Color(255, 255, 255));
            X_item466.setEditable(true);

            X_item500.setBackground(new Color(255, 255, 255));
            X_item500.setEditable(true);
            X_item511.setBackground(new Color(255, 255, 255));
            X_item511.setEditable(true);
            X_item522.setBackground(new Color(255, 255, 255));
            X_item522.setEditable(true);
            X_item533.setBackground(new Color(255, 255, 255));
            X_item533.setEditable(true);
            X_item544.setBackground(new Color(255, 255, 255));
            X_item544.setEditable(true);
            X_item555.setBackground(new Color(255, 255, 255));
            X_item555.setEditable(true);
            X_item566.setBackground(new Color(255, 255, 255));
            X_item566.setEditable(true);

            X_item600.setBackground(new Color(255, 255, 255));
            X_item600.setEditable(true);
            X_item611.setBackground(new Color(255, 255, 255));
            X_item611.setEditable(true);
            X_item622.setBackground(new Color(255, 255, 255));
            X_item622.setEditable(true);
            X_item633.setBackground(new Color(255, 255, 255));
            X_item633.setEditable(true);
            X_item644.setBackground(new Color(255, 255, 255));
            X_item644.setEditable(true);
            X_item655.setBackground(new Color(255, 255, 255));
            X_item655.setEditable(true);
            X_item666.setBackground(new Color(255, 255, 255));
            X_item666.setEditable(true);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        p_Working = new javax.swing.JPanel();
        p_matrixSize = new javax.swing.JPanel();
        T_NumberNmatrix = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        b_saveLength = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        P_matrixItems = new javax.swing.JPanel();
        b_saveLength1 = new javax.swing.JButton();
        p_ForItems = new javax.swing.JPanel();
        X_item00 = new javax.swing.JTextField();
        X_item03 = new javax.swing.JTextField();
        X_item01 = new javax.swing.JTextField();
        X_item02 = new javax.swing.JTextField();
        X_item04 = new javax.swing.JTextField();
        X_item05 = new javax.swing.JTextField();
        X_item06 = new javax.swing.JTextField();
        X_item100 = new javax.swing.JTextField();
        X_item111 = new javax.swing.JTextField();
        X_item122 = new javax.swing.JTextField();
        X_item133 = new javax.swing.JTextField();
        X_item144 = new javax.swing.JTextField();
        X_item155 = new javax.swing.JTextField();
        X_item166 = new javax.swing.JTextField();
        X_item366 = new javax.swing.JTextField();
        X_item355 = new javax.swing.JTextField();
        X_item344 = new javax.swing.JTextField();
        X_item333 = new javax.swing.JTextField();
        X_item322 = new javax.swing.JTextField();
        X_item311 = new javax.swing.JTextField();
        X_item300 = new javax.swing.JTextField();
        X_item200 = new javax.swing.JTextField();
        X_item211 = new javax.swing.JTextField();
        X_item222 = new javax.swing.JTextField();
        X_item233 = new javax.swing.JTextField();
        X_item244 = new javax.swing.JTextField();
        X_item255 = new javax.swing.JTextField();
        X_item266 = new javax.swing.JTextField();
        X_item522 = new javax.swing.JTextField();
        X_item544 = new javax.swing.JTextField();
        X_item533 = new javax.swing.JTextField();
        X_item566 = new javax.swing.JTextField();
        X_item555 = new javax.swing.JTextField();
        X_item633 = new javax.swing.JTextField();
        X_item644 = new javax.swing.JTextField();
        X_item611 = new javax.swing.JTextField();
        X_item622 = new javax.swing.JTextField();
        X_item466 = new javax.swing.JTextField();
        X_item411 = new javax.swing.JTextField();
        X_item400 = new javax.swing.JTextField();
        X_item655 = new javax.swing.JTextField();
        X_item666 = new javax.swing.JTextField();
        X_item444 = new javax.swing.JTextField();
        X_item455 = new javax.swing.JTextField();
        X_item422 = new javax.swing.JTextField();
        X_item433 = new javax.swing.JTextField();
        X_item600 = new javax.swing.JTextField();
        X_item500 = new javax.swing.JTextField();
        X_item511 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        P_addKeyPt = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        T_MyCT = new javax.swing.JTextField();
        b_Decryption = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        L_resuilt = new javax.swing.JLabel();
        b_Decryption1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        p_Working.setBackground(new java.awt.Color(204, 255, 255));
        p_Working.setLayout(new java.awt.CardLayout());

        p_matrixSize.setBackground(new java.awt.Color(255, 255, 255));

        T_NumberNmatrix.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        T_NumberNmatrix.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        T_NumberNmatrix.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                T_NumberNmatrixKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Matrix Length Number ");

        b_saveLength.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        b_saveLength.setForeground(new java.awt.Color(0, 153, 153));
        b_saveLength.setText("Save ");
        b_saveLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveLengthActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("IF you need matrix 5* 5 writ the lenght = 5 and so on ");

        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Add Numbers and click Save and travel To Add The Matrix Content");

        javax.swing.GroupLayout p_matrixSizeLayout = new javax.swing.GroupLayout(p_matrixSize);
        p_matrixSize.setLayout(p_matrixSizeLayout);
        p_matrixSizeLayout.setHorizontalGroup(
            p_matrixSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_matrixSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_matrixSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_matrixSizeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_saveLength, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_matrixSizeLayout.createSequentialGroup()
                        .addGroup(p_matrixSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_matrixSizeLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(48, 48, 48)
                                .addComponent(T_NumberNmatrix, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 120, Short.MAX_VALUE)))
                .addContainerGap())
        );
        p_matrixSizeLayout.setVerticalGroup(
            p_matrixSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_matrixSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(p_matrixSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_NumberNmatrix, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(b_saveLength)
                .addContainerGap())
        );

        p_Working.add(p_matrixSize, "size");

        P_matrixItems.setBackground(new java.awt.Color(255, 255, 255));

        b_saveLength1.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        b_saveLength1.setForeground(new java.awt.Color(0, 153, 153));
        b_saveLength1.setText("Save ");
        b_saveLength1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveLength1ActionPerformed(evt);
            }
        });

        p_ForItems.setBackground(new java.awt.Color(0, 102, 102));
        p_ForItems.setToolTipText("Matrix Item");

        X_item00.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item00.setForeground(new java.awt.Color(0, 102, 102));
        X_item00.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item00.setText("a");
        X_item00.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item00.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item03.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item03.setForeground(new java.awt.Color(0, 102, 102));
        X_item03.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item03.setText("d");
        X_item03.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item03.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item01.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item01.setForeground(new java.awt.Color(0, 102, 102));
        X_item01.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item01.setText("b");
        X_item01.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item01.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item02.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item02.setForeground(new java.awt.Color(0, 102, 102));
        X_item02.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item02.setText("c");
        X_item02.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item02.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item04.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item04.setForeground(new java.awt.Color(0, 102, 102));
        X_item04.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item04.setText("e");
        X_item04.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item04.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item05.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item05.setForeground(new java.awt.Color(0, 102, 102));
        X_item05.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item05.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item05.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item06.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item06.setForeground(new java.awt.Color(0, 102, 102));
        X_item06.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item06.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item06.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item100.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item100.setForeground(new java.awt.Color(0, 102, 102));
        X_item100.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item100.setText("f");
        X_item100.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item100.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item111.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item111.setForeground(new java.awt.Color(0, 102, 102));
        X_item111.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item111.setText("g");
        X_item111.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item111.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item122.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item122.setForeground(new java.awt.Color(0, 102, 102));
        X_item122.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item122.setText("h");
        X_item122.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item122.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item133.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item133.setForeground(new java.awt.Color(0, 102, 102));
        X_item133.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item133.setText("i");
        X_item133.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item133.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item144.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item144.setForeground(new java.awt.Color(0, 102, 102));
        X_item144.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item144.setText("j");
        X_item144.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item144.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item155.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item155.setForeground(new java.awt.Color(0, 102, 102));
        X_item155.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item155.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item155.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item166.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item166.setForeground(new java.awt.Color(0, 102, 102));
        X_item166.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item166.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item166.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item366.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item366.setForeground(new java.awt.Color(0, 102, 102));
        X_item366.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item366.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item366.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item355.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item355.setForeground(new java.awt.Color(0, 102, 102));
        X_item355.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item355.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item355.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item344.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item344.setForeground(new java.awt.Color(0, 102, 102));
        X_item344.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item344.setText("t");
        X_item344.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item344.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item333.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item333.setForeground(new java.awt.Color(0, 102, 102));
        X_item333.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item333.setText("s");
        X_item333.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item333.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item322.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item322.setForeground(new java.awt.Color(0, 102, 102));
        X_item322.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item322.setText("r");
        X_item322.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item322.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item311.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item311.setForeground(new java.awt.Color(0, 102, 102));
        X_item311.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item311.setText("q");
        X_item311.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item311.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item300.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item300.setForeground(new java.awt.Color(0, 102, 102));
        X_item300.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item300.setText("p");
        X_item300.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item300.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item200.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item200.setForeground(new java.awt.Color(0, 102, 102));
        X_item200.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item200.setText("k");
        X_item200.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item200.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item211.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item211.setForeground(new java.awt.Color(0, 102, 102));
        X_item211.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item211.setText("l");
        X_item211.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item211.setSelectionColor(new java.awt.Color(0, 204, 204));
        X_item211.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                X_item211ActionPerformed(evt);
            }
        });

        X_item222.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item222.setForeground(new java.awt.Color(0, 102, 102));
        X_item222.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item222.setText("m");
        X_item222.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item222.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item233.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item233.setForeground(new java.awt.Color(0, 102, 102));
        X_item233.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item233.setText("n");
        X_item233.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item233.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item244.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item244.setForeground(new java.awt.Color(0, 102, 102));
        X_item244.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item244.setText("o");
        X_item244.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item244.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item255.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item255.setForeground(new java.awt.Color(0, 102, 102));
        X_item255.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item255.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item255.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item266.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item266.setForeground(new java.awt.Color(0, 102, 102));
        X_item266.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item266.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item266.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item522.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item522.setForeground(new java.awt.Color(0, 102, 102));
        X_item522.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item522.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item522.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item544.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item544.setForeground(new java.awt.Color(0, 102, 102));
        X_item544.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item544.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item544.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item533.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item533.setForeground(new java.awt.Color(0, 102, 102));
        X_item533.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item533.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item533.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item566.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item566.setForeground(new java.awt.Color(0, 102, 102));
        X_item566.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item566.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item566.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item555.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item555.setForeground(new java.awt.Color(0, 102, 102));
        X_item555.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item555.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item555.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item633.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item633.setForeground(new java.awt.Color(0, 102, 102));
        X_item633.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item633.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item633.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item644.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item644.setForeground(new java.awt.Color(0, 102, 102));
        X_item644.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item644.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item644.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item611.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item611.setForeground(new java.awt.Color(0, 102, 102));
        X_item611.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item611.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item611.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item622.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item622.setForeground(new java.awt.Color(0, 102, 102));
        X_item622.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item622.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item622.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item466.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item466.setForeground(new java.awt.Color(0, 102, 102));
        X_item466.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item466.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item466.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item411.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item411.setForeground(new java.awt.Color(0, 102, 102));
        X_item411.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item411.setText("v");
        X_item411.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item411.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item400.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item400.setForeground(new java.awt.Color(0, 102, 102));
        X_item400.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item400.setText("u");
        X_item400.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item400.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item655.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item655.setForeground(new java.awt.Color(0, 102, 102));
        X_item655.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item655.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item655.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item666.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item666.setForeground(new java.awt.Color(0, 102, 102));
        X_item666.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item666.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item666.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item444.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item444.setForeground(new java.awt.Color(0, 102, 102));
        X_item444.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item444.setText("y");
        X_item444.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item444.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item455.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item455.setForeground(new java.awt.Color(0, 102, 102));
        X_item455.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item455.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item455.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item422.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item422.setForeground(new java.awt.Color(0, 102, 102));
        X_item422.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item422.setText("w");
        X_item422.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item422.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item433.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item433.setForeground(new java.awt.Color(0, 102, 102));
        X_item433.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item433.setText("x");
        X_item433.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item433.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item600.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item600.setForeground(new java.awt.Color(0, 102, 102));
        X_item600.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item600.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item600.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item500.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item500.setForeground(new java.awt.Color(0, 102, 102));
        X_item500.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item500.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item500.setSelectionColor(new java.awt.Color(0, 204, 204));

        X_item511.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        X_item511.setForeground(new java.awt.Color(0, 102, 102));
        X_item511.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        X_item511.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102)));
        X_item511.setSelectionColor(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout p_ForItemsLayout = new javax.swing.GroupLayout(p_ForItems);
        p_ForItems.setLayout(p_ForItemsLayout);
        p_ForItemsLayout.setHorizontalGroup(
            p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ForItemsLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(X_item600, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item500, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item400, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item300, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item200, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item100, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item00, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(X_item01, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item111, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item211, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item311, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item411, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item511, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item611, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(X_item02, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item122, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item222, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item322, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item422, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item522, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item622, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(X_item03, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item133, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item233, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item333, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item433, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item533, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item633, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(X_item04, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item144, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item244, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item344, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item444, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item544, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item644, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(X_item05, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item155, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item255, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item355, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item455, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item555, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item655, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(X_item06, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item166, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item266, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item366, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item466, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item566, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item666, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        p_ForItemsLayout.setVerticalGroup(
            p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ForItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(X_item00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(X_item100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item133, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item155, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item166, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(X_item200, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item244, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item211, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item222, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item233, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item255, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item266, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(X_item300, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item344, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item311, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item322, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item333, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item355, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item366, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(X_item400, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item444, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item411, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item422, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item433, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item455, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item466, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(X_item500, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item544, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item511, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item522, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item533, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item555, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item566, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(p_ForItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(X_item600, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item644, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item611, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item622, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item633, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item655, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X_item666, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("You Can add One char Or More In The Same Item ");

        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("To Create The Matrix Add The Items of the Matrix ");

        javax.swing.GroupLayout P_matrixItemsLayout = new javax.swing.GroupLayout(P_matrixItems);
        P_matrixItems.setLayout(P_matrixItemsLayout);
        P_matrixItemsLayout.setHorizontalGroup(
            P_matrixItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_matrixItemsLayout.createSequentialGroup()
                .addGroup(P_matrixItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_matrixItemsLayout.createSequentialGroup()
                        .addContainerGap(342, Short.MAX_VALUE)
                        .addComponent(b_saveLength1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(P_matrixItemsLayout.createSequentialGroup()
                        .addGroup(P_matrixItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(P_matrixItemsLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(p_ForItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(P_matrixItemsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(P_matrixItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        P_matrixItemsLayout.setVerticalGroup(
            P_matrixItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_matrixItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(p_ForItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(b_saveLength1)
                .addContainerGap())
        );

        p_Working.add(P_matrixItems, "items");

        P_addKeyPt.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Cipher Text");

        T_MyCT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        T_MyCT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        T_MyCT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        T_MyCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_MyCTActionPerformed(evt);
            }
        });
        T_MyCT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                T_MyCTKeyPressed(evt);
            }
        });

        b_Decryption.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        b_Decryption.setForeground(new java.awt.Color(0, 153, 153));
        b_Decryption.setText("Decryption");
        b_Decryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_DecryptionActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Plant Text");

        L_resuilt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        L_resuilt.setForeground(new java.awt.Color(0, 153, 153));
        L_resuilt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_resuilt.setText(" ");

        b_Decryption1.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        b_Decryption1.setForeground(new java.awt.Color(0, 153, 153));
        b_Decryption1.setText("BACK");
        b_Decryption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_Decryption1ActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Add The KEY And The Cipher Text .. Then Click On Encryption");

        javax.swing.GroupLayout P_addKeyPtLayout = new javax.swing.GroupLayout(P_addKeyPt);
        P_addKeyPt.setLayout(P_addKeyPtLayout);
        P_addKeyPtLayout.setHorizontalGroup(
            P_addKeyPtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_addKeyPtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_addKeyPtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_resuilt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(P_addKeyPtLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_addKeyPtLayout.createSequentialGroup()
                        .addGroup(P_addKeyPtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(P_addKeyPtLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(T_MyCT, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(P_addKeyPtLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(P_addKeyPtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(P_addKeyPtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(b_Decryption))))
                        .addGap(49, 49, 49)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_addKeyPtLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(b_Decryption1))
        );
        P_addKeyPtLayout.setVerticalGroup(
            P_addKeyPtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_addKeyPtLayout.createSequentialGroup()
                .addGroup(P_addKeyPtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_addKeyPtLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(T_MyCT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_addKeyPtLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_Decryption)
                .addGap(20, 20, 20)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(L_resuilt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(b_Decryption1))
        );

        p_Working.add(P_addKeyPt, "keypt");

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Composition Between Transaction and substitution ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_Working, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(p_Working, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void T_NumberNmatrixKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_T_NumberNmatrixKeyTyped
        try {
            char c = evt.getKeyChar();
            if (c < '0' || c > '9') {
                evt.consume();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_T_NumberNmatrixKeyTyped

    private void b_saveLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveLengthActionPerformed

        if (!T_NumberNmatrix.getText().equals("")) {
            N = Integer.parseInt(T_NumberNmatrix.getText());
            if (N <= 7 && N >= 3) {
                setBackGround();
                c.show(p_Working, "items");
            } else {
                JOptionPane.showMessageDialog(this, "Pleas Enter Avalid Length For Matrix Could Be Between 3 and 7 .");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pleas Enter Length Of Matrix.");
        }


    }//GEN-LAST:event_b_saveLengthActionPerformed

    private void b_saveLength1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveLength1ActionPerformed

        getMyTextField();
        MyMatrix = new String[N][N];
        boolean flag = true;
        System.out.println("Matrix");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                MyMatrix[i][j] = MYTextField[i][j].getText().replace(" ", "");
                if (MyMatrix[i][j].equals("")) {
                    flag = false;
                }
                System.out.print(MyMatrix[i][j] + "    ");
            }
            System.out.println("");
        }
        System.out.println("_______________________________________________");
        if (!flag) {
            JOptionPane.showMessageDialog(this, "Pleas Enter Valuse IN All Items Of The Matix ");
        } else {
            c.show(p_Working, "keypt");
            ArrCol = "abcdefg".toCharArray();
            ArrRow = "abcdefg".toCharArray();
        }

    }//GEN-LAST:event_b_saveLength1ActionPerformed

    private void T_MyCTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_T_MyCTKeyPressed
        L_resuilt.setText(" ");
    }//GEN-LAST:event_T_MyCTKeyPressed

    private void b_DecryptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_DecryptionActionPerformed

        getAll2DChar(getArrOFPT(T_MyCT.getText()));
        getArrChar2DTowRowDecode();
        L_resuilt.setText(GetCTDEcryprion());
    }//GEN-LAST:event_b_DecryptionActionPerformed

    private void X_item211ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_X_item211ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_X_item211ActionPerformed

    private void T_MyCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_MyCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T_MyCTActionPerformed

    private void b_Decryption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_Decryption1ActionPerformed
       c.show(p_Working, "size");
    }//GEN-LAST:event_b_Decryption1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Security.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Security.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Security.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Security.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Security service = new Security();
                service.ArrTextField = service.getArrTextFields(X_item00, X_item01, X_item02, X_item03, X_item04, X_item05, X_item06, X_item100,
                        X_item111, X_item122, X_item133, X_item144, X_item155, X_item166, X_item200, X_item211, X_item222, X_item233, X_item244,
                        X_item255, X_item266, X_item300, X_item311, X_item322, X_item333, X_item344, X_item355, X_item366, X_item400, X_item411, X_item422,
                        X_item433, X_item444, X_item455, X_item466, X_item500, X_item511, X_item522, X_item533, X_item544, X_item555,
                        X_item566, X_item500, X_item611, X_item622, X_item633, X_item644, X_item655, X_item666
                );
                service.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel L_resuilt;
    private javax.swing.JPanel P_addKeyPt;
    private javax.swing.JPanel P_matrixItems;
    private javax.swing.JTextField T_MyCT;
    public static javax.swing.JTextField T_NumberNmatrix;
    public static javax.swing.JTextField X_item00;
    public static javax.swing.JTextField X_item01;
    public static javax.swing.JTextField X_item02;
    public static javax.swing.JTextField X_item03;
    public static javax.swing.JTextField X_item04;
    public static javax.swing.JTextField X_item05;
    public static javax.swing.JTextField X_item06;
    public static javax.swing.JTextField X_item100;
    public static javax.swing.JTextField X_item111;
    public static javax.swing.JTextField X_item122;
    public static javax.swing.JTextField X_item133;
    public static javax.swing.JTextField X_item144;
    public static javax.swing.JTextField X_item155;
    public static javax.swing.JTextField X_item166;
    public static javax.swing.JTextField X_item200;
    public static javax.swing.JTextField X_item211;
    public static javax.swing.JTextField X_item222;
    public static javax.swing.JTextField X_item233;
    public static javax.swing.JTextField X_item244;
    public static javax.swing.JTextField X_item255;
    public static javax.swing.JTextField X_item266;
    public static javax.swing.JTextField X_item300;
    public static javax.swing.JTextField X_item311;
    public static javax.swing.JTextField X_item322;
    public static javax.swing.JTextField X_item333;
    public static javax.swing.JTextField X_item344;
    public static javax.swing.JTextField X_item355;
    public static javax.swing.JTextField X_item366;
    public static javax.swing.JTextField X_item400;
    public static javax.swing.JTextField X_item411;
    public static javax.swing.JTextField X_item422;
    public static javax.swing.JTextField X_item433;
    public static javax.swing.JTextField X_item444;
    public static javax.swing.JTextField X_item455;
    public static javax.swing.JTextField X_item466;
    public static javax.swing.JTextField X_item500;
    public static javax.swing.JTextField X_item511;
    public static javax.swing.JTextField X_item522;
    public static javax.swing.JTextField X_item533;
    public static javax.swing.JTextField X_item544;
    public static javax.swing.JTextField X_item555;
    public static javax.swing.JTextField X_item566;
    public static javax.swing.JTextField X_item600;
    public static javax.swing.JTextField X_item611;
    public static javax.swing.JTextField X_item622;
    public static javax.swing.JTextField X_item633;
    public static javax.swing.JTextField X_item644;
    public static javax.swing.JTextField X_item655;
    public static javax.swing.JTextField X_item666;
    public static javax.swing.JButton b_Decryption;
    public static javax.swing.JButton b_Decryption1;
    public static javax.swing.JButton b_saveLength;
    public static javax.swing.JButton b_saveLength1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel p_ForItems;
    private javax.swing.JPanel p_Working;
    private javax.swing.JPanel p_matrixSize;
    // End of variables declaration//GEN-END:variables
}
