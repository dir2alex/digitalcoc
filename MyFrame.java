import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Calendar;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;

public class MyFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("coc");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        //this.setResizable(false);

        timeFormat= new SimpleDateFormat("hh:mm:ss a");
        dayFormat= new SimpleDateFormat("E");
        dateFormat= new SimpleDateFormat("MM dd, yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Impact",Font.PLAIN,50));
        timeLabel.setForeground(new Color(255, 255, 255));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Times New Roman",Font.PLAIN,35));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Times New Roman",Font.PLAIN,25));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while(true){
            String time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
