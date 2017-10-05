/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Alina
 */
public class bTree
{
    private bTreeNode root;
    private bTreeNode temp;
    
    public bTree()
    {
        root=null;
    }
    
    public boolean isEmpty()
    { 
        return (root == null); 
    } 
    
    public void Add(String NodeData)// int wordCount)
    {
        if (NodeData.compareTo("") != 0)
        {
            temp = new bTreeNode();
            temp.setData(NodeData);
            //temp.counter = wordCount;
            if(root == null)
            {
                root = temp;
                //temp.counter ++;
            }

             else
            {
               RecAddNode(root);
            }
        }
    }
    
    private void RecAddNode(bTreeNode CurrentNode)
    {
        int order = CurrentNode.getData().compareTo(temp.data);
        if(order<0)
        {
            if(CurrentNode.leftnode == null)
            {
                CurrentNode.leftnode = temp;
               //temp.counter ++;
            }
            else
            {
                RecAddNode(CurrentNode.leftnode);
            }
       }
        else if(order>0)
        {
            if(CurrentNode.rightnode == null)
            {
                CurrentNode.rightnode = temp;
                
            }   
            else
            {
                RecAddNode(CurrentNode.rightnode);
                    
            }
        }
        else
        {
            CurrentNode.counter ++;
        }
    }
    
    public String Print()
    {
        //counts = temp.counter;
        return recPrint(root);
    }

    private String recPrint(bTreeNode Current)
    {
        String tempString = "";    
            if(Current.rightnode!=null)
                tempString = recPrint(Current.rightnode);

            tempString += " " + Current.getData() + " : " + Current.counter + "  ; ";

            if(Current.leftnode!=null)
                tempString += " " + recPrint(Current.leftnode);
            
        
                   return tempString;
    }
    
}
