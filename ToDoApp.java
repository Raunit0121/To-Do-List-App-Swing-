import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public ToDoApp() {
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the list model and components
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskInput = new JTextField(20);

        // Buttons
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        // Add task logic
        addButton.addActionListener(e -> {
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText("");
            }
        });

        // Delete task logic
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });

        // Top panel
        JPanel panel = new JPanel();
        panel.add(taskInput);
        panel.add(addButton);
        panel.add(deleteButton);

        // Layout
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoApp().setVisible(true);
        });
    }
}
