package swing;

import entity.Person;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificareMenu implements ActionListener
{
    private JFrame frame = new JFrame();
    private JTextField name = new JTextField();
    private JTextField surname = new JTextField();
    private JTextField address = new JTextField();
    private JButton salveaza = new JButton("Salveaza");
    private Repository repository;
    private int index;

    public ModificareMenu(Repository repo, int personIndex) {
        this.repository = repo;
        this.index = personIndex;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Adaugare Menu");
        frame.setVisible(true);
        frame.setLayout(new GridLayout(7, 1));
        frame.setSize(300, 300);

        var currentPerson = repository.getPerson(index);

        frame.add(new JLabel("Name"));
        name.setText(currentPerson.getName());
        frame.add(name);
        frame.add(new JLabel("Surname"));
        surname.setText(currentPerson.getSurname());
        frame.add(surname);
        frame.add(new JLabel("Address"));
        address.setText(currentPerson.getAddress());
        frame.add(address);

        salveaza.addActionListener(this);

        frame.add(salveaza);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == salveaza) {
            repository.updatePerson(index, name.getText(), surname.getText(), address.getText());
            frame.setVisible(false);
            frame.dispose();
        }
    }
}
