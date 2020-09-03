package study.taste.protobuf3;

import study.taste.protobuf3.proto.AddressBookProto.PhoneNumber;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static study.taste.protobuf3.proto.AddressBookProto.AddressBook;
import static study.taste.protobuf3.proto.AddressBookProto.Person;
import static study.taste.protobuf3.proto.AddressBookProto.PhoneType;

public class Main {
  
  public static final String TXT_FILE = "./tester-address.txt";
  
  public static void main(String[] args) throws IOException {
    final PhoneNumber phoneNumber = PhoneNumber.newBuilder()
        .setType(PhoneType.MOBILE)
        .setNumber("010-1111-2222")
        .build();
    
    final Person person = Person.newBuilder()
        .setEmail("tester@test.com")
        .setId(0x0001)
        .setName("tester")
        .setPhone(phoneNumber)
        .build();
    
    final AddressBook addressBook = AddressBook.newBuilder()
        .setPerson(person)
        .build();
    
    final FileOutputStream out = new FileOutputStream(TXT_FILE);
    addressBook.writeTo(out);
    out.close();
  
    final AddressBook parsed = AddressBook.parseFrom(new FileInputStream(TXT_FILE));
  
    System.out.println(parsed);
  
  }
  
}
