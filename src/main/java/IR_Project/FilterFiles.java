package IR_Project;


public class FilterFiles extends ParseFiles {

    /**
     * Checks if file is txt file
     * @param file
     * @return true if txt else false
     */
    public static boolean isTextFile(String file) {
        file = file.toLowerCase();
        if (file.lastIndexOf('.') > 0 && file.substring(file.lastIndexOf('.') + 1).equals("txt")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if file is html file
     * @param file
     * @return true if html else false
     */
    public static boolean isHTMLFile(String file) {
        file = file.toLowerCase();
        if (file.lastIndexOf('.') > 0) {
            String extension = file.substring(file.lastIndexOf('.') + 1);
            if (extension.equals("html") || extension.equals("htm")) {
                return true;
            }
        }
        return false;
        }

        public static DocumentFields getInstance(String path)
        {

            System.out.println("Parsing all File: "+path);
            String[] name = new String[2];
            if(isTextFile(path)) {
                name = parseText(path);
            }else if(isHTMLFile(path)){
                name = parseHTML(path);
            }else {
                System.out.println(" No txt or html files Found!");
                System.exit(1);
            }

            return new DocumentFields(name[0],name[1],path);
        }


    }

