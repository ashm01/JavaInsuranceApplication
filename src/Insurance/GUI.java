package Insurance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * A class to create the GUI for the insurance application
 *
 * @author Ash
 */
public class GUI extends JFrame {
    //Defining the class variables

    private static ClientDetailsList cList;
    private JFrame mainFrame;
    private JTextField surnameInput, postcodeInput, idInput;
    private JPanel homePanel, findPanel, showAllPanel, searchForPanel, addressPanel;
    private JLabel titleLab;
    private JButton findButton, searchButton, showAllButton, searchForButton,
            addressButton;
    private JTextArea resultArea;
    private JScrollPane scrollBox;

    public GUI(ClientDetailsList temp) {
        //Initialising the clintdetails list
        cList = temp;
        //Creating the main frame for the app
        mainFrame = new JFrame("Insurance Application");
        //Creating the main/home panel for the app
        homePanel = new JPanel();
        //Setting the background colour of the panel
        homePanel.setBackground(Color.lightGray);
        //Allows the layout to customised intsead of stuck to a grid
        homePanel.setLayout(null);
        //Add a label to the top of the app
        titleLab = new JLabel("Insurance Application");
        //Creating a specif font for the label
        Font f = new Font("Dialog", Font.PLAIN, 24);
        //Setting the font to one above
        titleLab.setFont(f);
        //Hover over text and locaton
        titleLab.setToolTipText("Welcome");
        titleLab.setBounds(130, 20, 400, 80);
        //add the item to the panel 
        homePanel.add(titleLab);
        //Creating the find button which when click will open a new panel
        //where the user will be able to search for a client
        findButton = new JButton("Find Client ID");
        findButton.setBounds(50, 130, 170, 120);
        //adding the action to button when it is clicked
        //Creates the find client panel
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set home panel to not visible
                homePanel.setVisible(false);
                //create the new panel for the search page
                findPanel = new JPanel();
                findPanel.setBackground(Color.lightGray);
                findPanel.setLayout(null);
                //adding a go back button to return to the main page
                JButton backButton = new JButton("Go Back");
                //Set thep position of the button
                backButton.setBounds(20, 20, 120, 40);
                //add the button to the panel 
                findPanel.add(backButton);
                //Define the action when the back button is clicked
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        findPanel.setVisible(false);
                        homePanel.setVisible(true);
                    }
                });
                //Label and text field for the surname input
                titleLab = new JLabel("Find Client ID Search");
                //Creating a specif font for the label
                Font f = new Font("Dialog", Font.PLAIN, 24);
                //Setting the font to one above
                titleLab.setFont(f);
                //Hover over text and locaton
                titleLab.setToolTipText("Find Client");
                titleLab.setBounds(180, 20, 400, 80);
                //add the item to the panel 
                findPanel.add(titleLab);
                //Label and text field for the surname input
                JLabel surnameLab = new JLabel("Client Surname:");
                surnameLab.setBounds(30, 170, 400, 20);
                //adding the surnamelabel to the panel
                findPanel.add(surnameLab);
                //creating the input box for the surname
                surnameInput = new JTextField("");
                surnameInput.setBounds(160, 170, 100, 20);
                findPanel.add(surnameInput);
                //Label and text field for the postcode input
                JLabel postcodeLab = new JLabel("Client Postcode:");
                postcodeLab.setBounds(30, 210, 400, 20);
                findPanel.add(postcodeLab);
                postcodeInput = new JTextField("");
                postcodeInput.setBounds(160, 210, 100, 20);
                findPanel.add(postcodeInput);
                //Creating the submit search buttom
                searchButton = new JButton("Search");
                searchButton.setBounds(160, 270, 100, 40);
                searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Creating variables which will be sent to find the client 
                        //info
                        String surname = surnameInput.getText();
                        String postcode = postcodeInput.getText();
                        resultArea.setText("");
                        resultArea.append(cList.findClient(surname, postcode));
                    }
                });
                //Add the search button to the panel
                findPanel.add(searchButton);
                //creating the scroll pane where the results
                //will be displayed
                JLabel idResultLab = new JLabel("Client ID Number:");
                idResultLab.setBounds(30, 340, 400, 20);
                findPanel.add(idResultLab);
                //Creating the area where the reults will be displayed
                resultArea = new JTextArea();
                resultArea.setEditable(false);
                JScrollPane scrollBox = new JScrollPane(resultArea);
                scrollBox.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollBox.setBounds(160, 340, 200, 75);
                findPanel.add(scrollBox);

                //Add the panel to the main frame
                mainFrame.add(findPanel);


            }
            //This is where the find panel ends!
        });

        homePanel.add(findButton);

        //Creating the show all clients button
        showAllButton = new JButton("Show All Clients");
        showAllButton.setBounds(270, 130, 170, 120);
        //Defining the actions to be performed when the button is clicked
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set home panel to not visible
                homePanel.setVisible(false);
                //create the new panel for the search page
                showAllPanel = new JPanel();
                showAllPanel.setBackground(Color.lightGray);
                showAllPanel.setLayout(null);
                //Label and text field for the surname input
                titleLab = new JLabel("Display All Clients");
                //Creating a specif font for the label
                Font f = new Font("Dialog", Font.PLAIN, 24);
                //Setting the font to one above
                titleLab.setFont(f);
                //Setting the position of th object
                titleLab.setBounds(180, 20, 400, 80);
                //add the item to the panel 
                showAllPanel.add(titleLab);
                //adding a go back button to return to the main page
                JButton backButton = new JButton("Go Back");
                //Set thep position of the button
                backButton.setBounds(20, 20, 120, 40);
                //add the button to the panel 
                showAllPanel.add(backButton);
                //Define the action when the back button is clicked
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showAllPanel.setVisible(false);
                        homePanel.setVisible(true);
                    }
                });
                //Creating the retrieve all clients button by redefining the show
                //all button
                showAllButton = new JButton("Retrieve Clients");
                showAllButton.setBounds(140, 130, 170, 50);
                //Defining the actions to be performed when the button is clicked
                showAllButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        resultArea.setText("");
                        resultArea.append(cList.toString());


                    }
                });
                showAllPanel.add(showAllButton);
                JLabel idResultLab = new JLabel("All Clients:");
                idResultLab.setBounds(30, 200, 400, 20);
                showAllPanel.add(idResultLab);
                //Creating the result area
                resultArea = new JTextArea();
                resultArea.setEditable(false);
                JScrollPane scrollBox = new JScrollPane(resultArea);
                scrollBox.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollBox.setBounds(100, 230, 300, 150);
                showAllPanel.add(scrollBox);
                mainFrame.add(showAllPanel);
            }
            //This is where the showall panel ends!!
        });
        homePanel.add(showAllButton);
        //Creating home panel button to open search for client
        searchForButton = new JButton("Search for a Client");
        searchForButton.setBounds(50, 300, 170, 120);
        searchForButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set home panel to not visible
                homePanel.setVisible(false);
                //create the new panel for the search page
                searchForPanel = new JPanel();
                searchForPanel.setBackground(Color.lightGray);
                searchForPanel.setLayout(null);
                //Label and text field for the surname input
                titleLab = new JLabel("Client Search");
                //Creating a specif font for the label
                Font f = new Font("Dialog", Font.PLAIN, 24);
                //Setting the font to one above
                titleLab.setFont(f);
                //Setting the position of th object
                titleLab.setBounds(180, 20, 400, 80);
                //add the item to the panel 
                searchForPanel.add(titleLab);
                //adding a go back button to return to the main page
                JButton backButton = new JButton("Go Back");
                //Set thep position of the button
                backButton.setBounds(20, 20, 120, 40);
                //add the button to the panel 
                searchForPanel.add(backButton);
                //Define the action when the back button is clicked
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchForPanel.setVisible(false);
                        homePanel.setVisible(true);
                    }
                });
                //creating the label and text field for the client id input
                JLabel clientIDLab = new JLabel("Client ID:");
                clientIDLab.setBounds(30, 170, 400, 20);
                searchForPanel.add(clientIDLab);
                idInput = new JTextField("");
                idInput.setBounds(160, 170, 100, 20);
                idInput.setText("");
                searchForPanel.add(idInput);
                //Defining and creating the search button to retrieve one 
                //specific clients deatils
                searchButton = new JButton("Search");
                searchButton.setBounds(160, 210, 100, 40);
                searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Creating variables which will be sent to find the client 
                        //info
                        String id = idInput.getText();

                        ClientDetails result = cList.getClientDetails(id);
                        resultArea.setText("");
                        //If statement to check the result isnt null
                        if (result == null) {
                            resultArea.append("Client Not Found!");
                        } else {

                            resultArea.append(result.toString());
                        }

                    }
                });
                //Add the search button to the panel
                searchForPanel.add(searchButton);
                JLabel idResultLab = new JLabel("Client Information:");
                idResultLab.setBounds(30, 255, 400, 20);
                searchForPanel.add(idResultLab);
                resultArea = new JTextArea();
                resultArea.setEditable(false);
                scrollBox = new JScrollPane(resultArea);
                scrollBox.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollBox.setBounds(100, 290, 300, 120);
                searchForPanel.add(scrollBox);
                mainFrame.add(searchForPanel);
            }//This is where the search for panel ends!!
        });
        homePanel.add(searchForButton);

        addressButton = new JButton("Same Address Check");
        addressButton.setBounds(270, 300, 170, 120);
        addressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //set home panel to not visible
                homePanel.setVisible(false);
                //create the new panel for the search page
                addressPanel = new JPanel();
                addressPanel.setBackground(Color.lightGray);
                addressPanel.setLayout(null);
                //Label and text field for the surname input
                titleLab = new JLabel("Address Check");
                //Creating a specif font for the label
                Font f = new Font("Dialog", Font.PLAIN, 24);
                //Setting the font to one above
                titleLab.setFont(f);
                //Setting the position of th object
                titleLab.setBounds(180, 20, 400, 80);
                //add the item to the panel 
                addressPanel.add(titleLab);
                //adding a go back button to return to the main page
                JButton backButton = new JButton("Go Back");
                //Set thep position of the button
                backButton.setBounds(20, 20, 120, 40);
                //add the button to the panel 
                addressPanel.add(backButton);
                //Define the action when the back button is clicked
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addressPanel.setVisible(false);
                        homePanel.setVisible(true);
                    }
                });
                //creating the label and text field for the client id input
                JLabel clientIDLab = new JLabel("Client ID:");
                clientIDLab.setBounds(30, 170, 400, 20);
                addressPanel.add(clientIDLab);
                idInput = new JTextField("");
                idInput.setBounds(160, 170, 100, 20);
                addressPanel.add(idInput);
                //Defining and creating the search button to retrieve one 
                //specific clients deatils
                searchButton = new JButton("Search");
                searchButton.setBounds(160, 210, 100, 40);
                searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Creating variables which will be sent to find the client 
                        //info
                        String id = idInput.getText();
                        ClientDetails temp2 = null;
                        //If statement to check the input is valid
                        if (id.matches("[I][C][-][x]\\d\\d\\d\\d\\d.")) {
                            ClientDetails result = cList.getClientDetails(id);
                            if (result != null){
                            temp2 = cList.sameAddressCheck(result);
                            resultArea.setText("");}

                            //if within the first if to make sure null is not
                            //returned from the method
                            resultArea.setText("");
                            if (result == null) {
                                resultArea.append("No Client Address Match!");
                            }
                            if (temp2 == null) {
                                resultArea.append("No Client Address Match!");
                            } else {

                                resultArea.append(temp2.toString());
                            }
                        } else {
                            resultArea.setText("");
                            resultArea.append("No Client Address Match!");
                        }
                    }
                });
                //Add the search button to the panel
                addressPanel.add(searchButton);

                JLabel idResultLab = new JLabel("Clients with same address:");
                idResultLab.setBounds(30, 255, 400, 20);
                addressPanel.add(idResultLab);
                resultArea = new JTextArea();
                resultArea.setEditable(false);
                scrollBox = new JScrollPane(resultArea);
                scrollBox.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollBox.setBounds(100, 290, 300, 120);
                addressPanel.add(scrollBox);

                mainFrame.add(addressPanel);
            }//This is where the address search panel ends!!
        });
        homePanel.add(addressButton);
        //Defining the main frame
        mainFrame.add(homePanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);



    }
}
