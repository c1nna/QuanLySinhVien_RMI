/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package inf;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Student;
/**
 *
 * @author Admin
 */
public interface Interface extends Remote{
    public String insert(Student s) throws RemoteException;
    
    public String update(Student s) throws RemoteException;
    
    public String delete(Student s) throws RemoteException;
    
    public List<Student> search(Student s) throws RemoteException;
    
    public List<Student> load() throws RemoteException;
}
