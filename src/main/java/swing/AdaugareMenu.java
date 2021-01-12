package swing;

import entity.Person;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class AdaugareMenu implements ActionListener {

    private JFrame frame = new JFrame();
    private JTextField name = new JTextField();
    private JTextField surname = new JTextField();
    private JTextField address = new JTextField();
    private JButton salveaza = new JButton("Salveaza");
    private Repository repository;

    public AdaugareMenu(Repository repo) {
        this.repository = repo;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Adaugare Menu");
        frame.setVisible(true);
        frame.setLayout(new GridLayout(7, 1));
        frame.setSize(300, 300);

        frame.add(new JLabel("Name"));
        frame.add(name);
        frame.add(new JLabel("Surname"));
        frame.add(surname);
        frame.add(new JLabel("Address"));
        frame.add(address);

        salveaza.addActionListener(this);

        frame.add(salveaza);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == salveaza) {
            Person entity = new Person(name.getText(), surname.getText(), address.getText());
            repository.add(entity);
            frame.setVisible(false);
            frame.dispose();
        }
    }
}
