package queue2;


public class Person
{
    private String name;
    public Person( )
    {
        name = "No name yet";
    }
    
    public Person(String initialFName)
    {
        name = initialFName;
       
    }
    
    public void setName(String newFName)
    {
        name = newFName;
    }
    
    
   
    public String getName( )
    {
        return name;
    }
    
    
    public void writeOutput( )
    {
        System.out.println("Name: " + name);
    }
   
    public boolean hasSameName(Person otherPerson)
    {
        return this.name.equalsIgnoreCase(otherPerson.name);
    }
}
