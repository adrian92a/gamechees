package work;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class chees extends javax.swing.JFrame 
{
    public chees() 
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")                   
    public void initComponents() 
    {
      addMouseListener(new java.awt.event.MouseAdapter() 
        {
            public void mouseReleased(java.awt.event.MouseEvent evt) 
            {
                formMouseReleased(evt);
            }
        });
        jScrollBar1 = new javax.swing.JScrollBar();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1250, 1100));
        setResizable(false);
        getContentPane().setLayout(null);
        jButton1.setText("Cofnij ruch");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1000, 180, 110, 30);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(1000, 220, 170, 400);
        
        pack();   
    }         
   @Override
         public void paint(Graphics g)
            {
                    graczCzarny.put(1, BlackPawn1);
                    graczCzarny.put(2, BlackPawn2);
                    graczCzarny.put(3, BlackPawn3);
                    graczCzarny.put(4, BlackPawn4);
                    graczCzarny.put(5, BlackPawn5);
                    graczCzarny.put(6, BlackPawn6);
                    graczCzarny.put(7, BlackPawn7);
                    graczCzarny.put(8, BlackPawn8);
                    graczCzarny.put(9, BlackRook1);
                    graczCzarny.put(16, BlackRook2);
                    graczCzarny.put(13, BlackQueen);
                    graczCzarny.put(12, BlackKing);
                    graczCzarny.put(11, BlackKBishop1);
                    graczCzarny.put(14, BlackKBishop2);
                    graczCzarny.put(10, BlackKnight1);
                    graczCzarny.put(15, BlackKnight2);
                    graczBialy.put(1, WhitePawn1);
                    graczBialy.put(2, WhitePawn2);
                    graczBialy.put(3, WhitePawn3);
                    graczBialy.put(4, WhitePawn4);
                    graczBialy.put(5, WhitePawn5);
                    graczBialy.put(6, WhitePawn6);
                    graczBialy.put(7, WhitePawn7);
                    graczBialy.put(8, WhitePawn8);
                    graczBialy.put(9, WhiteRook1);
                    graczBialy.put(16, WhiteRook2);
                    graczBialy.put(13, WhiteQueen);
                    graczBialy.put(12, WhiteKing);
                    graczBialy.put(11, WhiteKBishop1);
                    graczBialy.put(14, WhiteKBishop2);
                    graczBialy.put(10, WhiteKnight1);
                    graczBialy.put(15, WhiteKnight2);    
                    gracz.put(1, graczBialy);
                    gracz.put(2, graczCzarny);
                    g.setColor(Color.BLUE);
                        g.fillRect(100, 100, 800, 800);
                        for(int i=200;i<900;i+=200)
                        {
                                for(int j=200;j<900;j+=200)
                                {
                                     g.clearRect(i-100, j-100, 100, 100);
                                }
                        }
                        for(int i=200;i<900;i+=200)
                        {
                                for(int j=200;j<900;j+=200)
                                {
                                     g.clearRect(i, j, 100, 100);
                                }
                        }
                        for(int i=1;i<17;i++) 
                        {
                            if(graczCzarny.get(i).czyIstnieje()==0)
                                    g.drawImage(graczCzarny.get(i).getFace().getImage(),getWidth(graczCzarny.get(i).getX()), getHeight(graczCzarny.get(i).getY()), this);
                                }
                        for(int i=1;i<17;i++)
                                {
                                    if(graczBialy.get(i).czyIstnieje()==0)
                                    g.drawImage(graczBialy.get(i).getFace().getImage(),getWidth(graczBialy.get(i).getX()), getHeight(graczBialy.get(i).getY()), this);
                                }
                        jButton1.setForeground(Color.yellow);
                        jTextArea1.setBackground(Color.yellow);
            }
           int counter=0;
                        int count=0;
                        int przeciwnik;
                        int szach;
                        int x;
                        int y;
                        int x_;
                        int y_;
   private void formMouseReleased(java.awt.event.MouseEvent evt) 
   { 
       if(nowaGra.getNumerRuchu()%2==1)
                        {
                        wybranyGracz.setGracz(1);
                        }
                        if  (nowaGra.getNumerRuchu()%2==0)
                        {
                            wybranyGracz.setGracz(2);
                        }
                        if(zaznaczonyGracz.getZaznaczonyGracz()==wybranyGracz.getGracz())
                        {
                        click.setXY(evt.getX(), evt.getY());
                                if(!(prezKtoregoGraczaZajete(getCol(click.getX()),getRow(click.getY()))==wybranyGracz.getGracz()))
                                {
                                    if(!(jakaFiguraZaznaczona.getJakaFiguraZaznaczona()==0))
                                    {
                                        if(czyPoprawnyRuch(jakaFiguraZaznaczona.getJakaFiguraZaznaczona() , getCol(click.getX()), getRow(click.getY()),wybranyGracz.getGracz()))
                                        {
                                            
                                        }
                                        zbitaFiguraPrzeciwnik.setPrzeciwnik(wybranyGracz.getGracz());
                                        zbitaFiguraPrzeciwnik.setZbitaFigura(jakaFiguraLezy(getCol(click.getX()),getRow(click.getY())));
                                              wykonajRuch(
                                                      wybranyGracz.getGracz(),
                                                      gracz.get(wybranyGracz.getGracz()).get(jakaFiguraZaznaczona.getJakaFiguraZaznaczona()).getX(),
                                                      gracz.get(wybranyGracz.getGracz()).get(jakaFiguraZaznaczona.getJakaFiguraZaznaczona()).getY(),
                                                      getCol(click.getX()),
                                                      getRow(click.getY())
                                              );
                                              if(czySzachowany(zaznaczonyGracz.getZaznaczonyGracz()))
                                                {
                                                    System.out.println(jakaFiguraZaznaczona.getJakaFiguraZaznaczona());
                                                    System.out.println(getCol(click.getX()));
                                                    System.out.println(getCol(click.getY()));
                                                    System.out.println(wybranyGracz.getGracz());
                                                    if(poprawnoscRuchu.getczyPoprawny()==1)
                                                    {
                                                      cofnijRuch();
                                                    }
                                                }  
                                    }          
                                }
                                else
                                zaznaczonyGracz.setZaznaczonyGraczz(0);
                                jakaFiguraZaznaczona.setJakaFiguraZaznaczona(0);
                          repaint();       
                        }
                        else
                        {
                            click.setXY(evt.getX(), evt.getY());
                            zaznaczonyGracz.setZaznaczonyGraczz(prezKtoregoGraczaZajete(getCol(evt.getX()),getRow(evt.getY())));
                            jakaFiguraZaznaczona.setJakaFiguraZaznaczona(jakaFiguraLezy(getCol(evt.getX()),getRow(evt.getY()))); 
                        }
                        licznikKlikniec.setClick(1);
                       sprawdzSzachMat(wybranyGracz.getPrzeciwnik());
    }
   public void cofnijRuch()
    {    
        int x1= zapisaneRuchyGraczy.get(nowaGra.getNumerRuchu()).x;
        int y1= zapisaneRuchyGraczy.get(nowaGra.getNumerRuchu()).y;
        int x2= zapisaneRuchyGraczy.get(nowaGra.getNumerRuchu()).x_;
        int y2= zapisaneRuchyGraczy.get(nowaGra.getNumerRuchu()).y_;
        int przezKogoZajete = prezKtoregoGraczaZajete(x2,y2);
        int Figura = jakaFiguraLezy(x2, y2);
        gracz.get(przezKogoZajete).get(Figura).setXY(x1,y1);  
        if(zbitaFiguraPrzeciwnik.getPrzeciwnik()==wybranyGracz.getPrzeciwnik())
        {
            if(!(zbitaFiguraPrzeciwnik.getZbitaFigura()==0))
            {
                {
                    gracz.get(zbitaFiguraPrzeciwnik.getPrzeciwnik()).
                            get(zbitaFiguraPrzeciwnik.getZbitaFigura()).
                            setCzyIstnieje(0);
                }   
            }
        }
        nowaGra.setNumerRuchu(nowaGra.getNumerRuchu()-1);
    }
      public void cofnijRuchNaPotrzebyMetodySzachMat()
    {    
        int x1= zapisaneRuchyGraczy.get(nowaGra.getNumerRuchu()).x;
        int y1= zapisaneRuchyGraczy.get(nowaGra.getNumerRuchu()).y;
        int x2= zapisaneRuchyGraczy.get(nowaGra.getNumerRuchu()).x_;
        int y2= zapisaneRuchyGraczy.get(nowaGra.getNumerRuchu()).y_;
        int przezKogoZajete = prezKtoregoGraczaZajete(x2,y2);
        int Figura = jakaFiguraLezy(x2, y2);
        gracz.get(przezKogoZajete).get(Figura).setXY(x1,y1);  
       
            if(!(zbitaFiguraPrzeciwnik.getZbitaFigura()==0))
            {
                {
                    gracz.get(zbitaFiguraPrzeciwnik.getPrzeciwnik()).
                            get(zbitaFiguraPrzeciwnik.getZbitaFigura()).
                            setCzyIstnieje(0);
                }   
            }
        
        nowaGra.setNumerRuchu(nowaGra.getNumerRuchu()-1);
    }
   public void wykonajRuch(int numerPorzadkowyGracza,int x, int y, int x_, int y_)
{       
        int zbitaFigura =0;
        poprawnoscRuchu.setczyPoprawny(0);
        int przeciwnik=0;
        int aktualnyGracz = prezKtoregoGraczaZajete(x,y);
        int miejsceDocelowwe = prezKtoregoGraczaZajete(x_,y_);
        int numerFiguryNaMiejscuDocelowym=jakaFiguraLezy(x_,y_);
        if(numerPorzadkowyGracza==1)
        przeciwnik=2;
        if(numerPorzadkowyGracza==2)
        przeciwnik=1;
        int numerFigury =jakaFiguraLezy(x,y);
        if(!(aktualnyGracz==0) && ! (numerFigury==0))
            {
                if(czyWPlanszy(x,y) && czyWPlanszy(x_,y_))
                {    
                    if(aktualnyGracz==numerPorzadkowyGracza)
                    {
                        if(czyPoprawnyRuch(numerFigury,x_,y_,numerPorzadkowyGracza))
                        {
                            if(miejsceDocelowwe==0)
                            {
                                gracz.get(aktualnyGracz).get(numerFigury).setXY(x_, y_);
                                poprawnoscRuchu.setczyPoprawny(1);
                                zbitaFigura=0;
                            }
                            if(miejsceDocelowwe==przeciwnik)
                            {
                                gracz.get(miejsceDocelowwe).get(numerFiguryNaMiejscuDocelowym).setCzyIstnieje(1); 
                                zbitaFigura =numerFiguryNaMiejscuDocelowym;
                                gracz.get(aktualnyGracz).get(numerFigury).setXY(x_, y_);
                                poprawnoscRuchu.setczyPoprawny(1);
                            }
                            if(miejsceDocelowwe==aktualnyGracz)
                            {
                                zbitaFigura=0;
                                poprawnoscRuchu.setczyPoprawny(0);
                            }   
                        }       
                    }
                } 
            }   
        if(poprawnoscRuchu.getczyPoprawny()==1)
        {
            nowaGra.setNumerRuchu(nowaGra.getNumerRuchu()+1);
            zapisaneRuchyGraczy.put(nowaGra.getNumerRuchu(),new Wektor(x,y,x_,y_,zbitaFigura,przeciwnik));    
            zbitaFiguraPrzeciwnik.setZbitaFigura(zbitaFigura);
            zbitaFiguraPrzeciwnik.setPrzeciwnik(przeciwnik);
        }
}
   public TreeMap<Integer, Coords> listaMozliwychRuchow(int numerGracza,int numerFiigury)
   {
        Map<Integer, Coords> lista = new TreeMap<>();
            int numerPrzeciwnika = 0;
             int j=1;
            if(numerGracza==1) 
            numerPrzeciwnika=2;
             if(numerGracza==2)
            numerPrzeciwnika=1;
    for(int x=1;x<9;x++)
    {
        for(int y=1;y<9;y++)
        {
             if(czyPoprawnyRuch(numerFiigury ,  x,  y, numerGracza))
             {
                 if(prezKtoregoGraczaZajete(x,y)==0 || prezKtoregoGraczaZajete(x,y)==numerPrzeciwnika)
                 {
                    lista.put(j, new Coords(x,y));
                    j++;
                 }  
             }
        }
    }    
     return  (TreeMap) lista;
   }
   public  int[] wspolrzedneGracza(int numerGracza, int numerFigury)
       {
           int tabela[] = new int[2];
                  for(int i=1;i<17;i++)
                    {
                        if(gracz.get(numerGracza).get(numerFigury).czyIstnieje()==0)
                       {
                           for(int x=1; x<9;x++)
                            {
                                if(gracz.get(numerGracza).get(numerFigury).getX()==x)
                                {
                                    tabela[0]=x;
                                }
                            }
                             for(int y=1; y<9;y++)
                            {
                                if(gracz.get(numerGracza).get(numerFigury).getY()==y)
                                {
                                    tabela[1]=y;
                                }
                            }
                       }
                    }
                  return tabela;
       }
   public void sprawdzSzachMat(int przeciwnik)
   {
       int flaga=1;
        if(czySzachowany(przeciwnik))
        {
            for(int i=1;i<17;i++)
            {
                if(gracz.get(przeciwnik).get(i).czyIstnieje()==0)
                {
                    if(listaMozliwychRuchow(przeciwnik,i).size()>0)
                    {
                  
                        for(int j=1;j<=listaMozliwychRuchow(przeciwnik,i).size();j++)  
                        {
                            wykonajRuch(przeciwnik,wspolrzedneGracza(przeciwnik,i)[0],wspolrzedneGracza(przeciwnik,i)[1],listaMozliwychRuchow(przeciwnik,i).get(j).getX(),listaMozliwychRuchow(przeciwnik,i).get(j).getY());
                            if(!(czySzachowany(przeciwnik)))
                             {
                                 flaga=0;
                             }
                            if(poprawnoscRuchu.getczyPoprawny()==1)
                            {
                              cofnijRuchNaPotrzebyMetodySzachMat();
                            }
                        }
                    }
                      
                }    
            }
        }
        else
        {
            flaga=0;
        }
        String zwyciezca = null;
        if(przeciwnik==1)
            zwyciezca="czarny";
        
         if(przeciwnik==2)
            zwyciezca="bialy";
        
         JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        if(flaga==1)
        {
            System.out.println("szach mat");
            JOptionPane.showMessageDialog(frame, "Wygrywa gracz z kolorem "+ zwyciezca);
        }
   }
   public boolean czyWolne(int x, int y)
    {
          int flaga =0;
          if(!(jakaFiguraLezy(x,y)==0))
            {
                flaga =1;
            }
           if(flaga==0)
               return true;
           else
               return false;  
    };
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   
    }   
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chees().setVisible(true);
            }
        });
    }                 
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    int figuaBialego;
    int figuaCzarnego;
    Tile BlackPawn1 = new Tile(1,2,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("Black_Pawn.png")),0,0,0);
    Tile BlackPawn2 = new Tile(2,2,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("Black_Pawn.png")),0,0,0);
    Tile BlackPawn3 = new Tile(3,2,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("Black_Pawn.png")),0,0,0);
    Tile BlackPawn4 = new Tile(4,2,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("Black_Pawn.png")),0,0,0);
    Tile BlackPawn5 = new Tile(5,2,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("Black_Pawn.png")),0,0,0);
    Tile BlackPawn6 = new Tile(6,2,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("Black_Pawn.png")),0,0,0);
    Tile BlackPawn7 = new Tile(7,2,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("Black_Pawn.png")),0,0,0);
    Tile BlackPawn8 = new Tile(8,2,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("Black_Pawn.png")),0,0,0);  
    Tile BlackQueen = new Tile(4,1,new Figury("Queen",Toolkit.getDefaultToolkit().getImage("Black_Queen.png")),0,0,0);
    Tile BlackRook1 = new Tile(1,1,new Figury("Rook",Toolkit.getDefaultToolkit().getImage("Black_Rook.png")),0,0,0);
    Tile BlackRook2 = new Tile(8,1,new Figury("Rook",Toolkit.getDefaultToolkit().getImage("Black_Rook.png")),0,0,0);
    Tile BlackKBishop1 = new Tile(3,1,new Figury("Bishop",Toolkit.getDefaultToolkit().getImage("Black_Bishop.png")),0,0,0);
    Tile BlackKBishop2 = new Tile(6,1,new Figury("Bishop",Toolkit.getDefaultToolkit().getImage("Black_Bishop.png")),0,0,0);
    Tile BlackKnight1 = new Tile(2,1,new Figury("Knight",Toolkit.getDefaultToolkit().getImage("Black_Knight.png")),0,0,0);
    Tile BlackKnight2 = new Tile(7,1,new Figury("Knight",Toolkit.getDefaultToolkit().getImage("Black_Knight.png")),0,0,0);
    Tile BlackKing = new Tile(5,1,new Figury("King",Toolkit.getDefaultToolkit().getImage("Black_King.png")),0,0,0);
    ZbitaFiguraPrzeciwnik zbitaFiguraPrzeciwnik = new ZbitaFiguraPrzeciwnik(0,0);
    Click click=new Click(1,1);
    numerRuchu nowaGra = new numerRuchu(1);
    szach Szach =  new szach(0,0);
    numerKlikniecia licznikKlikniec  = new numerKlikniecia(1);
    WybranyGracz wybranyGracz = new WybranyGracz(1);
    czyPoprawnyRuch poprawnoscRuchu = new czyPoprawnyRuch(0);   
    ZaznaczonyGracz zaznaczonyGracz = new ZaznaczonyGracz(0);
    JakaFiguraZaznaczona jakaFiguraZaznaczona = new JakaFiguraZaznaczona(0);
    MiejsceWykonaniaRuchu miejsceWykonaniaRuchu = new MiejsceWykonaniaRuchu(0);
    Tile WhitePawn1 = new Tile(1,7,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_Pawn.png")),1,0,0);
    Tile WhitePawn2 = new Tile(2,7,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_Pawn.png")),1,0,0);
    Tile WhitePawn3 = new Tile(3,7,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_Pawn.png")),1,0,0);
    Tile WhitePawn4 = new Tile(4,7,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_Pawn.png")),1,0,0);
    Tile WhitePawn5 = new Tile(5,7,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_Pawn.png")),1,0,0);
    Tile WhitePawn6 = new Tile(6,7,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_Pawn.png")),1,0,0);
    Tile WhitePawn7= new Tile(7,7,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_Pawn.png")),1,0,0);
    Tile WhitePawn8 = new Tile(8,7,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_Pawn.png")),1,0,0);  
    Tile WhiteQueen = new Tile(5,8,new Figury("queen",Toolkit.getDefaultToolkit().getImage("White_Queen.png")),1,0,0);
    Tile WhiteRook1 = new Tile(1,8,new Figury("Rook",Toolkit.getDefaultToolkit().getImage("White_Rook.png")),1,0,0);
    Tile WhiteRook2 = new Tile(8,8,new Figury("Rook",Toolkit.getDefaultToolkit().getImage("White_Rook.png")),1,0,0);
    Tile WhiteKBishop1 = new Tile(3,8,new Figury("Bishop",Toolkit.getDefaultToolkit().getImage("White_Bishop.png")),1,0,0);
    Tile WhiteKBishop2 = new Tile(6,8,new Figury("Bishop",Toolkit.getDefaultToolkit().getImage("White_Bishop.png")),1,0,0);
    Tile WhiteKnight1 = new Tile(2,8,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_Knight.png")),1,0,0);
    Tile WhiteKnight2 = new Tile(7,8,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_Knight.png")),1,0,0);
    Tile WhiteKing = new Tile(4,8,new Figury("pawn",Toolkit.getDefaultToolkit().getImage("White_King.png")),1,0,0);
    Map<Integer, Map<Integer, Tile>> gracz = new TreeMap<>();
    Map<Integer, Tile> graczCzarny = new TreeMap<>();  
    Map<Integer, Tile> graczBialy= new TreeMap<>();
    Map<Integer,Wektor> zapisaneRuchyGraczy= new TreeMap<>();
     public int getHeight(int numberOfRow)
    {
        return 115+100*(numberOfRow-1);
    }
    public int getWidth(int numberOfCol)
    {
            return 117+100*(numberOfCol-1);
    };
    public int getCol(int width)
    {
        return  width/100;
    }
     public int getRow(int height)
    {
        return  height/100;
    }
     public boolean czySzachowany(int numerGracza)
     {
            int flaga =0;
            int przeciwnik = 0;
            if(numerGracza==1)
             przeciwnik=2;
            if(numerGracza==2)
               przeciwnik=1;
         int x = gracz.get(numerGracza).get(12).getX();
         int y = gracz.get(numerGracza).get(12).getY();
         for(int i=1; i<17;i++)
            {
                if(gracz.get(przeciwnik).get(i).czyIstnieje()==0)
                    {
                        if(czyPoprawnyRuch(i,x ,y,przeciwnik))
                        {
                          return true;
                        }
                    }
            }
        return false;   
     };
     public boolean czyPoprawnyRuch(int numerFiigury , int EndX, int EndY,int  numerGracza)
{   
    int X_= EndX;
    int Y_= EndY;
        int numerPrzeciwnika = 0;
      if(numerGracza==1)
        numerPrzeciwnika=2;
         if(numerGracza==2)
        numerPrzeciwnika=1;
        if(numerFiigury<9 & numerGracza ==2)
    {
        int x=gracz.get(2).get(numerFiigury).getX();
        int y=gracz.get(2).get(numerFiigury).getY();
       if(Y_==y+1 && (X_==x+1 || X_==x-1) && prezKtoregoGraczaZajete(X_,Y_)==1)
            {
                return true;
            }
        if(X_==gracz.get(2).get(numerFiigury).getX() && Y_-gracz.get(2).get(numerFiigury).getY()==1 && prezKtoregoGraczaZajete(X_,Y_)==0 )
            return true;
        if(gracz.get(2).get(numerFiigury).getY()==2 && X_==gracz.get(2).get(numerFiigury).getX()&& Y_-gracz.get(2).get(numerFiigury).getY()==2  && prezKtoregoGraczaZajete(X_,Y_)==0 )
            return true;
        else
            return false;
    }  
    if(numerFiigury<9 & numerGracza ==1)
    {
         int x=gracz.get(1).get(numerFiigury).getX();
        int y=gracz.get(1).get(numerFiigury).getY();
       if(Y_==y-1 && (X_==x+1 || X_==x-1) && prezKtoregoGraczaZajete(X_,Y_)==2)
            {
                return true;
            }
        if(X_==gracz.get(1).get(numerFiigury).getX() && -Y_+gracz.get(1).get(numerFiigury).getY()==1  && prezKtoregoGraczaZajete(X_,Y_)==0 )
            return true;
        if(gracz.get(1).get(numerFiigury).getY()==7 && X_==gracz.get(1).get(numerFiigury).getX()&& -Y_+gracz.get(1).get(numerFiigury).getY()==2 && prezKtoregoGraczaZajete(X_,Y_)==0 )
            return true;
        else
            return false;
    }
    if(numerFiigury==9 || numerFiigury==16)
    {
       if(czyStoiNaDrodze(
               gracz.get(numerGracza).get(numerFiigury).getX(),gracz.get(numerGracza).get(numerFiigury).getY(),X_,Y_) &&
               (gracz.get(numerGracza).get(numerFiigury).getX()==X_ || gracz.get(numerGracza).get(numerFiigury).getY()==Y_) && 
               czyWPlanszy(X_,Y_)  
               )
           return true;
       else
           return false;
    }
    if(numerFiigury==10 || numerFiigury==15)  
    {
       int X= gracz.get(numerGracza).get(numerFiigury).getX();
       int Y= gracz.get(numerGracza).get(numerFiigury).getY();
         if( czyWPlanszy(X_,Y_)  && (((Y==Y_-2 || Y ==Y_+2) && (X==X_-1 || X==X_+1)) || ((X==X_-2 || X ==X_+2) && (Y==Y_-1 || Y==Y_+1))))
         {
             return true;
         }
         else
             return false;
    }
if(numerFiigury ==11 || numerFiigury ==14)
{
    if(czyStoiNaDrodze(gracz.get(numerGracza).get(numerFiigury).getX(),gracz.get(numerGracza).get(numerFiigury).getY(),X_,Y_) && czyWPlanszy(X_,Y_))   
    {
       int X= gracz.get(numerGracza).get(numerFiigury).getX();
       int Y= gracz.get(numerGracza).get(numerFiigury).getY();
       int deltaX=X-X_;
       int deltaY=Y-Y_;
       
      if(!(deltaX==0) && !(deltaY==0) && (deltaY==deltaX || deltaY == -deltaX )&& czyWPlanszy(X_,Y_))
          return true;
          else
          return false;
    }
}    
    if(numerFiigury ==13)
    {  
        int X= gracz.get(numerGracza).get(numerFiigury).getX();
        int Y= gracz.get(numerGracza).get(numerFiigury).getY();
        int deltaX=X-X_;
        int deltaY=Y-Y_;
        if(czyStoiNaDrodze(gracz.get(numerGracza).get(numerFiigury).getX(),gracz.get(numerGracza).get(numerFiigury).getY(),X_,Y_) && czyWPlanszy(X_,Y_))   
    {
        if(!(deltaX==0) && !(deltaY==0) && (deltaY==deltaX || deltaY == -deltaX )&& czyWPlanszy(X_,Y_))
          return true;
    }
       if(((deltaX==0) ||(deltaY==0)))
       {
           if(czyStoiNaDrodze(gracz.get(numerGracza).get(numerFiigury).getX(),gracz.get(numerGracza).get(numerFiigury).getY(),X_,Y_))
           {
            {
                if(((gracz.get(numerGracza).get(numerFiigury).getX()==X_ || gracz.get(numerGracza).get(numerFiigury).getY()==Y_))&& czyWPlanszy(X_,Y_))
                    return true;
            }
           }
       }
       else 
           return false;
    }
    if(numerFiigury ==12)
    {
        int X= gracz.get(numerGracza).get(numerFiigury).getX();
        int Y= gracz.get(numerGracza).get(numerFiigury).getY();
        int deltaX=X-X_;
        int deltaY=Y-Y_;
          if((deltaX==1 && deltaY==0) || ((deltaX==-1 && deltaY==0)) || ((deltaX==0 && deltaY==-1)) || ((deltaX==0 && deltaY==1)) || ((deltaX==1 && deltaY==1)) ||((deltaX==1 && deltaY==-1)) || ((deltaX==-1 && deltaY==1)) || ((deltaX==-1 && deltaY==-1)) && czyWPlanszy(X_,Y_))
             return true;
         else
             return false;       
    }        
    return false;
};
    public boolean czyWPlanszy(int X, int Y)
    {
        if(0<X && X<9 && 0<Y && Y<9)
            return true;
        else
            return false;
    };
      public boolean czyStoiNaDrodze(int x, int y,int x_,int y_)
    {
        int flaga_ =0;
        int deltaX=x_-x;
        int deltaY=y_-y;
        if(x==x_)
        {
            if(deltaY>0)
            {
                flaga_ =0;
                for(int i=1;i<deltaY;i++)
                {
                    if(!czyWolne(x,y+i))
                        flaga_ =1;
                }
            }
            if(deltaY<0)
            {
                flaga_ =0;
                for(int i=-1;i>deltaY;i--)
                {
                    if(!czyWolne(x,y+i))
                    {
                        flaga_ =1;
                        break;
                    }    
                }     
            }    
        }
        if(y==y_)
        {
            if(deltaX>0)
            {
                flaga_ =0;
                for(int i=1;i<deltaX;i++)
                {
                    if(!czyWolne(x+i,y))
                    {
                        flaga_ =1;
                        break;
                    }    
                }
            }
            if(deltaX<0)
                flaga_ =0;
                for(int i=-1;i>deltaX;i--)
                {
                    if(!czyWolne(x+i,y))
                    {
                        flaga_ =1;
                        break;
                    }
                }
        }
        if(!(y==y_) & !(x==x_))
        {
            if(deltaX>0 && deltaY>0)
            {
                flaga_ =0;
                for(int i=1;i<deltaX;i++)
                {
                    if(!czyWolne(x+i,y+i))
                    {
                        flaga_ =1;
                        break;
                    }    
                }
            } 
            if(deltaX>0 && deltaY<0)
            {
                flaga_ =0;
                for(int i=1;i<deltaX;i++)
                {
                    if(!czyWolne(x+i,y-i))
                    {
                        flaga_ =1;
                        break;
                    }    
                }
            }
             if(deltaX<0 && deltaY>0)
            {
                flaga_ =0;
                for(int i=1;i<deltaY;i++)
                {
                    if(!czyWolne(x-i,y+i))
                    {
                        flaga_ =1;
                        break;
                    }    
                }
            } 
              if(deltaX<0 && deltaY<0)
            {
                flaga_ =0;
                for(int i=1;i<-deltaY;i++)
                {
                    if(!czyWolne(x-i,y-i))
                    {
                        flaga_ =1;
                        break;
                    }    
                }
            } 
        }
        if(flaga_==1)
            return false;
        else
            return true;
    };
       public int prezKtoregoGraczaZajete(int x, int y)
    {
        int ktoryGracz=0;
         for(int i=1;i<17;i++)
       {  
           if((gracz.get(2).get(i).getX()==x) && (gracz.get(2).get(i).getY()==y))
            {
                if(gracz.get(2).get(i).czyIstnieje()==0)
                ktoryGracz =2;
            }   
       }
         for(int i=1;i<17;i++)
       {  
           if((gracz.get(1).get(i).getX()==x) && (gracz.get(1).get(i).getY()==y))
           {    
               if(gracz.get(1).get(i).czyIstnieje()==0)
               ktoryGracz =1;
           }   
       }
        return ktoryGracz;
    };
    public int jakaFiguraLezy(int x, int y)
    {
        int flaga =0;
        {
            for(int i=1;i<17;i++)
            {
                if(gracz.get(1).get(i).czyIstnieje()==0)
               {
                    if((gracz.get(1).get(i).getX()==x) && (gracz.get(1).get(i).getY()==y))
                    flaga = i;
               }
            }
            for(int i=1;i<17;i++)
            {
               if(gracz.get(2).get(i).czyIstnieje()==0)
               {
                if((gracz.get(2).get(i).getX()==x) && (gracz.get(2).get(i).getY()==y))
                flaga = i;
               }
            }
            
        }    
        return flaga;   
    };
}  //* koniec klasy chees *// 
class numerRuchu
{
    private int _numerRuchu;
    public numerRuchu(int numer)
    {
        _numerRuchu=numer;
    }
    public int getNumerRuchu()
    {
        return _numerRuchu;
    }
    public void setNumerRuchu(int numer)
    {
         _numerRuchu=numer;
    }
}
class wybranaFigura
{
                private int _x;
                private int _y;
                private int __x;
                private int __y;
                private boolean _czyZaznaczona;
                 public wybranaFigura(int x,int y,int X, int Y,boolean czyZaznaczona )
                {
                      _x=x;
                      _y=y;
                    __x =X;
                     __y=Y;
                     _czyZaznaczona=czyZaznaczona;
                }
                public int getX()
                {
                    return _x;
                }
                    public int getY()
                {
                    return _y;
                }  
                public void    setXY(int X,int Y)
                {
                      __x= X;
                     __y = Y;
                }
                public int getEndX()
                {
                    return __x;
                }
                    public int getEndY()
                {
                    return __y;
                }
                public void    setEndXY(int X, int Y)
                {
                    __x= X;
                     __y = Y;
                }
                 public boolean getCzyZaznaczona()
                {
                    return _czyZaznaczona;
                }
                 public void setCzyZaznaczona(boolean czyZaznaczona)
                {
                     _czyZaznaczona=czyZaznaczona;
                }  
}
class Click
{
    private int _x;
    private int _y;
    public Click(int x,int y)
    {
        _x=x;
        _y=y;
    }
    public int getX()
    {
        return _x;
    }
        public int getY()
    {
        return _y;
    }    
    public void    setXY(int x,int y)
    {
          _x= x;
         _y = y;
    }
}
class Figury
{
    private String _nazwa;  
    private Image _img;
    private int _druzyna;
    public Figury( String nazwa, Image img)
    {
        _nazwa = nazwa;
        _img= img; 
    }
    public Image getImage()
    {
        return _img;
    }
    public String getNazwa()
    {
        return _nazwa;
    }
}
class szach
{
    private int czySzachowanyGracz1;
    private int czySzachowanyGracz2;
    public szach(int gracz1, int gracz2)
    {
        czySzachowanyGracz1= gracz1;
        czySzachowanyGracz2 =gracz2;
    }
    public int czySzachowanyGracz1()
    {
        return czySzachowanyGracz1;
    }
    public int czySzachowanyGracz2()
    {
        return czySzachowanyGracz2;
    }
    public void setczySzachowanyGracz1(int gracz1)
    {
        czySzachowanyGracz1 =gracz1;
    }
    public void setczySzachowanyGracz2(int gracz2)
    {
        czySzachowanyGracz2 =gracz2;
    }
}
class Tile 
{
    private int _row;   
    private int _col;     
    private Figury _face;  
    private int _czyIstnieje;
    private int _czyOdswiezyc;
    private int _colEnd;
    private int _rowEnd;
    private int _czyWykonacRuch;
    public Tile(int col, int row, Figury face,int czyIstnieje, int czyZaznaczony,int czyWykonacRuch)
    {
        _col = col;
        _row = row;
        _face = face;
    }
      public int czyIstnieje() 
    {
        return _czyIstnieje;
    }
      public int czyZaznaczony() 
    {
        return _czyOdswiezyc;
    }
      public int czyWykonacRuch() 
    {
        return _czyWykonacRuch;
    }
      public void setCzyIstnieje(int czyIstnieje)
    {
        _czyIstnieje= czyIstnieje;
    };
      public void setCzyZaznaczony(int cyzOdswieyzc)
    {
        _czyOdswiezyc= cyzOdswieyzc;
    };
      public void setCzyWykonacRuch(int czyWykonacRuch)
    {
        _czyWykonacRuch= czyWykonacRuch;
    };
    public void setFace(Figury newFace) 
    {
        _face = newFace;
    }
     public Figury getFace() 
    {
        return _face;
    }
    public void setXY(int X, int Y) 
    {
        _col = X;
         _row = Y;
    }
     public int getX() 
    {
        return _col;
    }
    public int getY() 
    {
        return _row;
       
    }  public void setEndXY(int EndX, int EndY) 
    {
        _colEnd = EndX;
         _rowEnd = EndY;
    }
}
class numerKlikniecia
{
     private int _click;
     private int _liczbaKlikniec;
     
     public numerKlikniecia(int click)
     {
         _click=click;
     }
    public int getClick()
    {
        return _click;
    }
    public void setClick(int liczbaKlikniec)
    {
        _click=_click+liczbaKlikniec;
    } 
}
class WybranyGracz
{
     private int _gracz;
     public WybranyGracz(int gracz)
     {
         _gracz=gracz;
     }
    public int getGracz()
    {
        return _gracz;
    }
    public void setGracz(int gracz)
    {
       _gracz=gracz; 
    }
     public int getPrzeciwnik()
    {
         if(_gracz==1)
        {
            return 2;
        }
        else
             return 1;
    }
        public void setWybierzNastepnegoGracza()
    {
        if(_gracz==1)
        {
            _gracz=2;
        }
        
        if(_gracz==2)
        {
            _gracz=1;
        }         
    }
} 
class czyPoprawnyRuch 
{
    int czyPoprawny_;
    public czyPoprawnyRuch(int czyPoprawny)
    {
        czyPoprawny_=czyPoprawny;
    }
    public void setczyPoprawny(int czyPoprawny)
    {
         czyPoprawny_=czyPoprawny;
    }
     public int getczyPoprawny()
    {
        return czyPoprawny_;
    }
}
class Wektor 
{
    int x;
    int y;
    int x_;
    int y_;
    int zbitaFigura_;
    int zbitaPrzezKogo_;
    public Wektor(int Xpoczatek, int Ypoczatek, int Xkoniec, int Ykoniec, int zbitaFigura, int zbitaPrzezKogo)
    {
        x=Xpoczatek;
        y=Ypoczatek;
        x_=Xkoniec;
        y_=Ykoniec;
        zbitaFigura_ =zbitaFigura;
        zbitaPrzezKogo_=zbitaPrzezKogo;
    }    
        public int getPoczX()
        {
            return x;
        }
        public int getPoczY()
        {
            return y;
        }
         public int getKoncX()
        {
            return x_;
        }
          public int getKoncY()
        {
            return y_;
        }
            public int getzbitaFigura()
        {
            return zbitaFigura_;
        }  
        public int getZbitaFiguraPrzezKogo()
        {
            return zbitaPrzezKogo_;
        }   
        public void setPoczX(int Xpoczatek)
        {
           x=Xpoczatek; 
        }
          public void setPoczY(int Ypoczatek)
        {
           x=Ypoczatek; 
        }
           public void setKoncX(int Xkoniec)
        {
           x=Xkoniec; 
        } 
        public void setZbitaFigura(int Ykoniec)
        {
           x=Ykoniec; 
        } 
         public void setZbitaPrzezKogo(int zbitaPrzezKogo)
        {
            zbitaPrzezKogo_=zbitaPrzezKogo; 
        }           
}
class ZaznaczonyGracz
{
     private int _gracz;
     public ZaznaczonyGracz(int gracz)
     {
         _gracz=gracz;
     }
    public int getZaznaczonyGracz()
    {
        return _gracz;
    }
    public void setZaznaczonyGraczz(int gracz)
    {
       _gracz=gracz; 
    }
} 
class MiejsceWykonaniaRuchu
{
     private int _gracz;
     public MiejsceWykonaniaRuchu(int gracz)
     {
         _gracz=gracz;
     }
    public int getMiejsceWykonaniaRuchu()
    {
        return _gracz;
    }
    public void setMiejsceWykonaniaRuchu(int gracz)
    {
       _gracz=gracz; 
    }
}
class JakaFiguraZaznaczona
{
     private int _gracz; 
     public JakaFiguraZaznaczona(int gracz)
     {
         _gracz=gracz;
     }
    public int getJakaFiguraZaznaczona()
    {
        return _gracz;
    }
    public void setJakaFiguraZaznaczona(int gracz)
    {
       _gracz=gracz; 
    }
}
class ZbitaFiguraPrzeciwnik
{
         private int _ZbitaFigura; 
         private int _Przeciwnik; 
     public ZbitaFiguraPrzeciwnik(int ZbitaFigura, int Przeciwnik)
     {
         _ZbitaFigura=ZbitaFigura;
         _Przeciwnik=Przeciwnik;
     }
    public int getZbitaFigura()
    {
        return _ZbitaFigura;
    }
    public int getPrzeciwnik()
    {
        return _Przeciwnik;
    }
    
    public void setZbitaFigura(int ZbitaFigura)
    {
       _ZbitaFigura=ZbitaFigura; 
    }
    
      public void setPrzeciwnik(int Przeciwnik)
    {
       _Przeciwnik=Przeciwnik; 
    }
}
    class Coords 
    {
        int x;
        int y;
        public Coords(int x, int y) 
        {
            this.x = x;
            this.y = y;
        }
        public int getX() 
        {
            return x;
        }
         public int getY() 
        {
            return y;
        }
    }

   

    


    
