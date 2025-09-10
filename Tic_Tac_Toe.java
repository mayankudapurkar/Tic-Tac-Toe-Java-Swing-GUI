import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Frame2  implements ActionListener,MouseListener
{
    JFrame frame = new JFrame();
    JPanel t_panel = new JPanel();
    JPanel bt_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] bton = new JButton[9];
    int chance_flag = 0;
    Random random = new Random();
    boolean pl1_chance;

    
    public Frame2() {
        frame.setSize(750, 750);
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        textfield.setText("Tic Tac Toe");
        textfield.setBackground(new Color(113, 27, 135));
        textfield.setForeground(new Color(255, 255, 255));
        textfield.setFont(new Font("Cambria", Font.BOLD, 70));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);

        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 100);

        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(new Color(0, 0, 0));

        for (int i = 0; i < 9; i++) {
            bton[i] = new JButton();
            bt_panel.add(bton[i]);
            bton[i].setFont(new Font("Times New Roman", Font.BOLD, 150));
            bton[i].setFocusable(false);
            bton[i].addActionListener(this);
            bton[i].addMouseListener(this);
            bton[i].setBackground(new Color(255, 255, 255));
        }

        t_panel.add(textfield);
        frame.add(t_panel, BorderLayout.NORTH);
        frame.add(bt_panel);

        startGame();


    }

    public void startGame() {
        try {
            textfield.setText("Game Loading...  ");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int chance = random.nextInt(100);

        if (chance % 2 == 0) {
            pl1_chance = true;
            textfield.setText(TicTacToeGame.tpl1.getText().trim().toUpperCase() + "'s turn");
        } else {
            pl1_chance = false;
            textfield.setText(TicTacToeGame.tpl2.getText().trim().toUpperCase() + "'s turn");
        }
    }

    public void gameOver(String s) {
        chance_flag = 0;
        String[] option = { "Replay", "New Game", "Exit" };
        int n = JOptionPane.showOptionDialog(frame, "Game Over\n" + s, "Game Over", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if (n == 0) {
            frame.dispose();
            new Frame2();
        } else if (n == 1) {
            frame.dispose();

            new TicTacToeGame();
        } else {
            frame.dispose();
        }

    }
    public void matchCheck() 
    {
        if ((bton[0].getText() == "X") && (bton[1].getText() == "X") && (bton[2].getText() == "X")) 
        {
            xWins(0, 1, 2);
        }
        else if ((bton[0].getText() == "X") && (bton[4].getText() == "X") && (bton[8].getText() == "X")) 
        {
            xWins(0, 4, 8);
        }
        else if ((bton[0].getText() == "X") && (bton[3].getText() == "X") && (bton[6].getText() == "X")) 
        {
            xWins(0, 3, 6);
        }
        else if ((bton[1].getText() == "X") && (bton[4].getText() == "X") && (bton[7].getText() == "X")) 
        {
            xWins(1, 4, 7);
        }
        else if ((bton[2].getText() == "X") && (bton[4].getText() == "X") && (bton[6].getText() == "X")) 
        {
            xWins(2, 4, 6);
        }
        else if ((bton[2].getText() == "X") && (bton[5].getText() == "X") && (bton[8].getText() == "X")) 
        {
            xWins(2, 5, 8);
        }
       else if ((bton[3].getText() == "X") && (bton[4].getText() == "X") && (bton[5].getText() == "X")) 
       {
            xWins(3, 4, 5);
        }
       else if ((bton[6].getText() == "X") && (bton[7].getText() == "X") && (bton[8].getText() == "X")) 
       {
            xWins(6, 7, 8);
        }
        else if ((bton[0].getText() == "O") && (bton[1].getText() == "O") && (bton[2].getText() == "O")) 
        {
            oWins(0, 1, 2);
        }
        else if ((bton[0].getText() == "O") && (bton[3].getText() == "O") && (bton[6].getText() == "O")) 
        {
            oWins(0, 3, 6);
        }
        else if ((bton[0].getText() == "O") && (bton[4].getText() == "O") && (bton[8].getText() == "O")) 
        {
            oWins(0, 4, 8);
        }
        else if ((bton[1].getText() == "O") && (bton[4].getText() == "O") && (bton[7].getText() == "O")) 
        {
            oWins(1, 4, 7);
        }
        else if ((bton[2].getText() == "O") && (bton[4].getText() == "O") && (bton[6].getText() == "O")) 
        {
            oWins(2, 4, 6);
        }
        else if ((bton[2].getText() == "O") && (bton[5].getText() == "O") && (bton[8].getText() == "O")) 
        {
            oWins(2, 5, 8);
        }
        else if ((bton[3].getText() == "O") && (bton[4].getText() == "O") && (bton[5].getText() == "O")) 
        {
            oWins(3, 4, 5);
        } else if ((bton[6].getText() == "O") && (bton[7].getText() == "O") && (bton[8].getText() == "O")) 
        {
            oWins(6, 7, 8);
        }
        else if(chance_flag==9) 
        {
            textfield.setText("Game Draw!!");
             gameOver("Game Draw!!");
        }
    }

  
    public void xWins(int x1, int x2, int x3) 
    {
        bton[x1].setBackground(new Color(204,255,153));
        bton[x2].setBackground(new Color(204,255,153));
        bton[x3].setBackground(new Color(204,255,153));

        for (int i = 0; i < 9; i++) 
        {
            bton[i].setEnabled(false);
        }
        textfield.setText(TicTacToeGame.tpl1.getText()+" wins");
        gameOver(TicTacToeGame.tpl1.getText()+" is the winner");
    }

 
    public void oWins(int x1, int x2, int x3) 
    {
        bton[x1].setBackground(new Color(204,255,153));
        bton[x2].setBackground(new Color(204,255,153));
        bton[x3].setBackground(new Color(204,255,153));

        for (int i = 0; i < 9; i++) 
        {
            bton[i].setEnabled(false);
        }
        textfield.setText(TicTacToeGame.tpl2.getText()+" wins");
        gameOver(TicTacToeGame.tpl2.getText()+" is the winner");
    }
     @Override
    public void mouseEntered(MouseEvent e)
    {
        for (int i = 0; i < 9; i++) 
        {
            if (e.getSource() == bton[i]) 
    {     
        bton[i].setBackground(new Color(255,214,179));
    }
        }
    }
     public void mouseClicked(MouseEvent e)
    {
       
    }
    public void mouseExited(MouseEvent e)
    {
        for (int i = 0; i < 9; i++) 
        {
            if (e.getSource() == bton[i]) 
    {     
        bton[i].setBackground(Color.WHITE);
    }
        }
    }
    public void mousePressed(MouseEvent e)
    {
       
    }
     public void mouseReleased(MouseEvent e)
    {
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
         for (int i = 0; i < 9; i++) 
        {
            if (e.getSource() == bton[i]) 
            {
                if (pl1_chance) 
                {
                    
                    if (bton[i].getText() == "") 
                    {
                        bton[i].setForeground(new Color(77,40,0));
                        bton[i].setText("X");
                        pl1_chance = false;
                        textfield.setFont(new Font("Cambria", Font.BOLD, 70));
                        textfield.setText(TicTacToeGame.tpl2.getText().trim().toUpperCase()+"'s turn (O)");
                        chance_flag++;
                        matchCheck();
                    }
                } 
                else 
                {
                    
                    if (bton[i].getText() == "") 
                    {
                        bton[i].setForeground(new Color(0,77,102));
                        bton[i].setText("O");
                        pl1_chance = true;
                        textfield.setFont(new Font("Cambria", Font.BOLD, 70));
                        textfield.setText(TicTacToeGame.tpl1.getText().trim().toUpperCase()+"'s turn (X)");
                        chance_flag++;
                        matchCheck();
                    }
                }
            }
        }
    }
    }

class TicTacToeGame implements ActionListener  
{  
    
    JFrame opening = new JFrame();
    JPanel op_panel1 = new JPanel();
    JPanel op_panel2 = new JPanel();
    public static JLabel  pl1,pl2,lbl1;
    public static JTextField tpl1,tpl2;
    JButton start,exit;
    boolean pl1_chance;
   
    
    TicTacToeGame() 
    {
        opening. setSize(750,450);
        opening.setTitle("TIC-TAC-TOE");
        opening.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        opening.setLocationRelativeTo(null);
        opening.setResizable(false);

        lbl1 = new JLabel("TIC-TAC-TOE");
        lbl1.setFont(new Font("Cambria",Font.BOLD,70));
        
        op_panel1.setBackground(new Color(48,25,52));
        lbl1.setForeground(Color.WHITE);
        op_panel1.add(lbl1);
        
        opening.add(op_panel1,BorderLayout.NORTH);
        op_panel2.setLayout(new GridLayout(3,2,40,40));
        op_panel2.setBackground(new Color(255,214,179));
        pl1 = new JLabel("Enter Player 1 Name :");
        pl1.setFont(new Font("Cambria",Font.BOLD,30));
        pl1.setForeground(new Color(48,25,52));
        pl2 = new JLabel("Enter Player 2 Name :");
        pl2.setForeground(new Color(48,25,52));
        pl2.setFont(new Font("Cambria",Font.BOLD,30));
        tpl1=new JTextField();
        tpl1.setFont(new Font("Cambria",Font.BOLD,28));
        tpl1.setSize(70,30);
        tpl2=new JTextField();
        tpl2.setFont(new Font("Cambria",Font.BOLD,28));
        op_panel2.add(pl1);
        op_panel2.add(tpl1);
        op_panel2.add(pl2);
        op_panel2.add(tpl2);
        start = new JButton("START GAME!!!");
        start.setBackground(new Color(153,255,102));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Cambria",Font.BOLD,28));
        start.addActionListener(this);
        exit = new JButton("EXIT");
        exit.setBackground(new Color(255,92,51));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Cambria",Font.BOLD,28));
        exit.addActionListener(this);
        op_panel2.add(start);
        op_panel2.add(exit);
        opening.add(op_panel2,BorderLayout.CENTER);
        opening.setVisible(true);
 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==start)
        {
            if(tpl1.getText().isEmpty() || tpl2.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(opening, "Please Enter Player Names!");
            }
            else
            {
            opening.dispose();
            new Frame2();
            }
        }

        if(e.getSource()==exit)
        {
            opening.dispose();
        }
    }

}


public class Tic_Tac_Toe{
    public static void main(String[] args) throws Exception 
    {
       new TicTacToeGame();
    }
}