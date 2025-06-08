package org.Design_Pattern.Creational;


/*

  The Prototype Design Pattern is a creational pattern used to clone existing objects instead of creating new ones from scratch. It’s useful when:

  Object creation is expensive (time or resources)
  You want to avoid complex object creation logic

  You fill a form online, and later want to fill a similar form again. Instead of starting from scratch,
  you duplicate the previous one and change only what's needed.
 */

class Document implements Cloneable {
    private String title;
    private String content;
    private String author;

    public Document(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void printDocument() {
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Author: " + author);
        System.out.println("----------------------------------");
    }

    @Override
    public Document clone() {
        return new Document(this.title, this.content, this.author);
    }
}

public class PrototypeDesignPattern {

    public static void main(String[] args) {
        Document template = new Document("NDA Template", "Confidential Agreement", "Legal Team");

        // Cloning the document
        Document doc1 = template.clone();
        doc1.setContent("Confidential Agreement for Vivek Singh");

        Document doc2 = template.clone();
        doc2.setContent("Confidential Agreement for Amit Kumar");

        // Print documents
        System.out.println("Original Template:");
        template.printDocument();

        System.out.println("Document 1:");
        doc1.printDocument();

        System.out.println("Document 2:");
        doc2.printDocument();
    }
}
