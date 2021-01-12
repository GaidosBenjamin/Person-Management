package swing;

import repository.Repository;
import service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton adaugare = new JButton("Adaugare obiect");
    private JButton listare = new JButton("Listare obiecte");
    private JButton iesire = new JButton("Iesire program");
    private Repository repository;

    public LaunchPage(Repository repo) {
        this.repository = repo;

        adaugare.setFocusable(false);
        adaugare.addActionListener(this);

        listare.setFocusable(false);
        listare.addActionListener(this);

        iesire.setFocusable(false);
        iesire.addActionListener(this);

        frame.add(adaugare);
        frame.add(listare);
        frame.add(iesire);

        frame.setTitle("Management persoane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 100);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == adaugare) {
            new AdaugareMenu(repository);
        }

        if(actionEvent.getSource() == iesire) {
            Service service = new Service();
            service.writePersonsToJson(repository.getPersonList());
            frame.setVisible(false);
            frame.dispose();
        }

        if(actionEvent.getSource() == listare) {
            new ListareMenu(repository);
        }
    }
}
