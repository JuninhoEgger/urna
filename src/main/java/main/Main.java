package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> votes = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\in.txt"))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                int count = parseInt(fields[1]);
                if (votes.containsKey(name)) {
                    int votesSoFar = votes.get(name);
                    votes.put(name, count + votesSoFar);
                } else {
                    votes.put(name, count);
                }
                line = br.readLine();
            }
            StringBuilder response = new StringBuilder("VOTOS\n");
            votes.keySet().forEach(key -> response.append(key).append(": ").append(votes.get(key)).append("\n"));
            showMessageDialog(null, response);

        } catch (IOException e) {
            showMessageDialog(null, e.getMessage());
        }
    }
}
