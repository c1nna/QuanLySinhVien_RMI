/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import model.Student;
/**
 *
 * @author Admin
 */
public class Server extends UnicastRemoteObject implements inf.Interface{
    private DAO dao;

    public Server() throws RemoteException{
        super();
        dao = new DAO();
    }
    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1099);
        Server server = new Server();
        reg.rebind("quanlysinhvien", server);
        System.out.println("RMI server is running...");
    }

    @Override
    public String insert(Student stu) throws RemoteException {
        if(dao.addStudent(stu)){
            return "ok";
        }
        else return "failed";
    }

    @Override
    public String update(Student s) throws RemoteException {
        if(dao.updateStudent(s)){
            return "ok";
        }
        else return "failed";
    }

    @Override
    public String delete(Student stu) throws RemoteException {
        if(dao.delStudent(stu)){
            return "ok";
        }
        else return "failed";
    }

    @Override
    public List<Student> search(Student stu) throws RemoteException {
        List<Student> list = dao.getStudentByName(stu);
        return list;
    }

    @Override
    public List<Student> load() throws RemoteException {
        return dao.getAll();
    }
}
