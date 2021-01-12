package swing;

import entity.Person;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListareMenu implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton modifica = new JButton("Modifica");
    private JButton sterge = new JButton("Sterge");
    private JButton revenire = new JButton("Revenire");
    private JList jList;
    private Repository repository;

    public ListareMenu(Repository repo) {
        this.repository = repo;

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 400);
        frame.setLayout(new FlowLayout());

        JPanel jPanel = new JPanel();
        var personList = repository.getPersonList();
        String[] names = new String[personList.size() + 1];
        for(int i = 0; i < personList.size(); i++) {
            names[i] = personList.get(i).getName();
        }
        jList = new JList(names);
        jPanel.add(jList);
        frame.add(jPanel);

        modifica.addActionListener(this);
        sterge.addActionListener(this);
        revenire.addActionListener(this);

        frame.add(modifica);
        frame.add(sterge);
        frame.add(revenire);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == revenire) {
            frame.setVisible(false);
            frame.dispose();
        }

        if(actionEvent.getSource() == sterge) {
            repository.delete(jList.getSelectedIndex());
            frame.setVisible(false);
            frame.dispose();
        }

        if(actionEvent.getSource() == modifica) {
            new ModificareMenu(repository, jList.getSelectedIndex());
            frame.setVisible(false);
            frame.dispose();
        }
    }
}
