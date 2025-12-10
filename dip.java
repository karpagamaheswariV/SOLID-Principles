public class Main {
    public static void main(String[] args) {

        User user = new User("Karpaga");

        NotificationService service = new NotificationService();

        service.notify(new EmailSender(), user, "Welcome via Email");
        service.notify(new SmsSender(), user, "Welcome via SMS");
    }
}

// ================================
// DIP-COMPLIANT IMPLEMENTATION
// ================================
interface Sender {
    void send(User user, String message);
}

class EmailSender implements Sender {
    public void send(User user, String message) {
        System.out.println("Email sent to " + user.name + ": " + message);
    }
}

class SmsSender implements Sender {
    public void send(User user, String message) {
        System.out.println("SMS sent to " + user.name + ": " + message);
    }
}

// High-level module depends on abstraction (Sender)
class NotificationService {
    public void notify(Sender sender, User user, String message) {
        sender.send(user, message);
    }
}

class User {
    String name;
    User(String name) {
        this.name = name;
    }
}

/*
=====================================================
DIP VIOLATION — COMMENTED OUT FOR REFERENCE
=====================================================

class NotificationService {
    EmailSender email = new EmailSender();   // depends on concrete class
    SmsSender sms = new SmsSender();         // depends on concrete class

    public void sendEmail(User user, String message) {
        email.send(user, message);
    }

    public void sendSms(User user, String message) {
        sms.send(user, message);
    }
}

Reason for Violation:
High-level module (NotificationService) directly depends on low-level modules
such as EmailSender and SmsSender. It should depend on an interface instead.
Any new communication channel requires modifying the class, making it rigid.
=====================================================
*/

