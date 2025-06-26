package org.Design_Pattern.Creational;


/*
The Factory Design Pattern is one of the most commonly used creational design patterns in Java and other
OOP languages. It provides a way to create objects without specifying the exact class of the object that
will be created.

The Factory Pattern defines an interface for creating an object but lets subclasses decide which class to instantiate.
It lets a class delegate the responsibility of instantiation to subclasses or another class.
 */


interface OperatingSystem {
    void showDirectoryCommand();
}

class WindowsOS implements OperatingSystem {
    @Override
    public void showDirectoryCommand() {
        System.out.println("Opening Explorer using: explorer.exe");
    }
}

class LinuxOS implements OperatingSystem {
    @Override
    public void showDirectoryCommand() {
        System.out.println("Opening File Manager using: nautilus");
    }
}

class MacOS implements OperatingSystem {
    @Override
    public void showDirectoryCommand() {
        System.out.println("Opening Finder using: open .");
    }
}

class OSFactory {
    public static OperatingSystem getOS(String osType) {
        if (osType == null) return null;

        return switch (osType.toLowerCase()) {
            case "windows" -> new WindowsOS();
            case "linux" -> new LinuxOS();
            case "mac" -> new MacOS();
            default -> throw new IllegalArgumentException("Unsupported OS type: " + osType);
        };
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        String currentOS = "linux";

        OperatingSystem os = OSFactory.getOS(currentOS);
        os.showDirectoryCommand();
    }
}

