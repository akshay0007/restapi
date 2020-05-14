package com.staxrt.tutorial.exception.newdir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class MainJavaClass {
    String dirPath = "C:\\Users\\karan\\Downloads\\workspace\\00.restapis\\restapi\\src\\main\\java\\com\\staxrt\\tutorial\\exception\\newdir";
    int noOfFiles = 4;
    int noOfRecords = 10000000;
    Map<String, PrintWriter> pwMaps = new HashMap<>();
    private String myfileName = "myfile.csv";
    String contentOne = "conetenone";
    String contentDecimal = "contentDecimal";
    File dir;
    private String COMMA = ",";
    private String NXT = "\n";
    Map<String, PathList> pathMap;
    private String sameFile = "sameFile.csv";
    private boolean keepOk = true;

    public static void main(String[] args) throws IOException {
        MainJavaClass mainJavaClass = new MainJavaClass();
        mainJavaClass.callTest();
    }

    private void callTest() throws IOException {
        createDir();
//        createPrintWriter();
//        writeCode();
        readCode();
    }

    private void readCode() {
        gettingFileInfo();
        System.out.println(pathMap.size());
        pathMap.entrySet().forEach(entry -> {
            PathList pathList = entry.getValue();
            File file1 = new File(String.valueOf(pathList.getPath1()));
            File file2 = new File(String.valueOf(pathList.getPath2()));
            Map<String, PrintWriterFile> printWriterMap = new HashMap<>();
            printWriterFile(file1.getName(), printWriterMap);
            compareLogicData(file1, file2, printWriterMap, true);
            compareLogicData(file2, file1, printWriterMap, false);
            closePrintWriters(printWriterMap);
        });
    }

    private void closePrintWriters(Map<String, PrintWriterFile> printWriterMap) {
        printWriterMap.entrySet().forEach(entry -> {
            PrintWriterFile pwFile = entry.getValue();
            if (pwFile.pwok != null) {
                pwFile.pwok.close();
            }
            if (pwFile.pwnok != null) {
                pwFile.pwnok.close();
            }
        });
    }

    private void printWriterFile(String name, Map<String, PrintWriterFile> map) {
        try {
            File fileNok = new File(dirPath, "nok." + name);
            PrintWriter pwnok = new PrintWriter(new FileWriter(fileNok));
            PrintWriter pwok = null;
            if (keepOk) {
                File fileok = new File(dirPath, "ok." + name);
                pwok = new PrintWriter(new FileWriter(fileok));
            }
            map.put(name, new PrintWriterFile(pwok, pwnok));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class PrintWriterFile {
        PrintWriter pwok;
        PrintWriter pwnok;

        public PrintWriterFile(PrintWriter pwok, PrintWriter pwnok) {
            this.pwok = pwok;
            this.pwnok = pwnok;
        }

        public PrintWriter getPwok() {
            return pwok;
        }

        public PrintWriter getPwnok() {
            return pwnok;
        }
    }

    private void compareLogicData(File file1, File file2, Map<String, PrintWriterFile> printWriterMap
            , boolean storeFromSecondBuffer) {
        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1))) {
            String row;
            Map<String, String> data = new HashMap<>();
            int count = 0;
            int maxLength = 1000000;
            ConcurrentHashMap<String, String> collectData = new ConcurrentHashMap<>();
            while ((row = bufferedReader1.readLine()) != null) {
                collectData.put(row, row);
                if (count % maxLength == 0 && count != 0) {
                    try (BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2))) {
                        compareLogic(bufferedReader2, collectData,
                                printWriterMap.get(file1.getName()), storeFromSecondBuffer);
                        addIntoFile(collectData, printWriterMap.get(file1.getName()), false);
                    }
                    System.out.println("compare all rows==" + count);
                    collectData.clear();
                }
                count++;
            }
            System.out.println(data.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addIntoFile(ConcurrentHashMap<String, String> collectData, PrintWriterFile pwFile, boolean isOk) {
        PrintWriter pw = isOk ? pwFile.getPwok() : pwFile.getPwnok();
        if (pw == null)
            return;
        for (Map.Entry<String, String> stringStringEntry : collectData.entrySet()) {
            synchronized (pw) {
                pw.append(stringStringEntry.getKey()).append(NXT);
            }
        }
    }

    private void compareLogic(BufferedReader bufferedReader2, ConcurrentHashMap<String, String> collectData,
                              PrintWriterFile pwFile,
                              boolean storeFromSecondBuffer) throws IOException {
        String row;
        while ((row = bufferedReader2.readLine()) != null) {
            if (collectData.get(row) != null) {
                PrintWriter pw = pwFile.getPwok();
                if (pw != null && storeFromSecondBuffer) {
                    synchronized (pw) {
                        pw.append(row).append(NXT);
                    }
                }
                collectData.remove(row);
            }
        }
    }

    private void gettingFileInfo() {
        try {
            pathMap = new HashMap<>();
            List<Path> listOne = Files.list(Paths.get(dir.getAbsolutePath())).collect(Collectors.toList());
            List<Path> listTwo = Files.list(Paths.get(dir.getAbsolutePath())).collect(Collectors.toList());
            listOne.forEach(path -> pathMap.put(String.valueOf(path.getFileName()), new PathList().setPath1(path)));
            listTwo.forEach(path -> {
                String fileName = String.valueOf(path.getFileName());
                PathList pathList = pathMap.get(fileName);
                if (pathList == null) {
                    pathMap.put(fileName, new PathList().setPath2(path));
                } else {
                    pathList.setPath2(path);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class PathList {
        Path path1;
        Path path2;

        public Path getPath1() {
            return path1;
        }

        public PathList setPath1(Path path1) {
            this.path1 = path1;
            return this;
        }

        public Path getPath2() {
            return path2;
        }

        public PathList setPath2(Path path2) {
            this.path2 = path2;
            return this;
        }
    }

    static class MyClass {
        String name;
        String age;
        String shoeSize;

        public MyClass(String name, String age, String shoeSize) {
            this.name = name;
            this.age = age;
            this.shoeSize = shoeSize;
        }

        public static MyClass constructFromStrings(List<String> values) {
            String _name = values.get(0);
            String _age = values.get(1);
            String _shoeSize = values.get(2);
            return new MyClass(_name, _age, _shoeSize);
        }

        public List<String> getValues() {
            Vector<String> values = new Vector<String>();
            values.add(name);
            values.add(age);
            values.add(shoeSize);
            return values;
        }
    }

    private void writeCode() {
        ExecutorService ex = Executors.newFixedThreadPool(4);
        List<Callable<Boolean>> callableArrayList = new ArrayList<>();
        for (int i = 0; i <= noOfFiles; i++) {
            callableArrayList.add(createCsv(i));
        }
        try {
            ex.invokeAll(callableArrayList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ex.shutdown();
        if (ex.isTerminated()) {
            closePrintWriter();
        }
    }

    private void closePrintWriter() {
        pwMaps.entrySet().forEach(entry -> entry.getValue().close());
    }

    private void createDir() {
        dir = new File(dirPath, "csvDir");
        dir.mkdir();
    }

    private void createPrintWriter() throws IOException {
        for (int i = 0; i < noOfFiles; i++) {
            String fileName = (i + myfileName).trim();
            File file = new File(dir, fileName);
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            pwMaps.put(fileName, pw);
        }
    }

    private Callable<Boolean> createCsv(int preFix) {
        return () -> {
            String fileName = (preFix + myfileName).trim();
            PrintWriter pw = pwMaps.get(fileName);
            synchronized (pw) {
                for (int i = 0; i < noOfRecords; i++) {
                    pw.append(i + contentOne).append(COMMA).append(i + contentDecimal).append(COMMA)
                            .append(i + contentDecimal).append(NXT);
                }
            }
            return Boolean.FALSE;
        };
    }


}
