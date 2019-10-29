package test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import test.Test.Person;

public class User extends Person implements Serializable {

  private static final long serialVersionUID = 2L;
  private String id;

  private String name;

  private transient String password;

  private transient long activationTime;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getActivationTime() {
    return activationTime;
  }

  public void setActivationTime(long activationTime) {
    this.activationTime = activationTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User(String id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }
  public static void say(){
    System.out.println("user");
  }
  public User() {
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", activationTime=" + activationTime +
        '}';
  }

  private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
    id = stream.readUTF();
    name = stream.readUTF();
    activationTime = System.currentTimeMillis();
    System.out.println("session deSerialized");
  }

  private void writeObject(ObjectOutputStream stream) throws IOException {
    stream.defaultWriteObject();
    stream.writeUTF(id);
    stream.writeUTF(name);
    System.out.println("session serialized");
  }


  public static void main(String[] args) {
    try {
      User user = new User("11", "lidan", "12345");
      File file = new File("out.txt");
      if (!file.exists()) {
        file.createNewFile();
      }
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
      objectOutputStream.writeObject(user);
      objectOutputStream.close();

      ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
      User readObject = (User) objectInputStream.readObject();
      System.out.println(readObject==user);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
