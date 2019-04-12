package br.com.Bandtec.RavenCrown.Infra.DAL;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Log {

        File arquivo;
        FileReader fileReader;
        BufferedReader bufferedReader;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        public void logLogin(String erros) {
            SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
            Date d = new Date();
            try {

                arquivo = new File("HistoryLg" + df.format(d) + ".txt"); //qual arquivo
                fileReader = new FileReader(arquivo);
                bufferedReader = new BufferedReader(fileReader);
                Vector texto = new Vector();

                while (bufferedReader.ready())//enquanto tiver algo p ler...
                {

                    texto.add(bufferedReader.readLine());//...vai adicionar em "texto"
                }
                fileWriter = new FileWriter(arquivo);
                bufferedWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < texto.size(); i++)//estrutura de repetição|
                // enquanto i for menor que texto, adiciona mais 1

                {
                    //armazenadentro do texto | recebe cada linha
                    //o .toString é porque a variavel não é uma String
                    //df.format(d);

                    bufferedWriter.write(texto.get(i).toString());

                    //pula linha | nva linha
                    bufferedWriter.newLine();

                }
                //escrever os erros
                bufferedWriter.write(erros);
                //fechar cada um fecha uma coisa diferente, por isso tem dois
                bufferedWriter.close();
                bufferedWriter.close();


            } catch (Exception ex) {
                try {
                    //caso não tiver um arquivo, ira criar um
                    arquivo.createNewFile();
                } catch (Exception error) {

                }
            }
        }
}