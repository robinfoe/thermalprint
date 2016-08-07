package com.sgdeals.lib.printer;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;

public class PrintExecutor {
	private static final String PRINTER_NAME = "Epson-TM-BA-Thermal";
	
	private static boolean feedPrinter(byte[] b)
    {
        try
        {

            AttributeSet attrSet = new HashPrintServiceAttributeSet(new PrinterName(PRINTER_NAME, null)); //EPSON TM-U220 ReceiptE4
            DocPrintJob job = PrintServiceLookup.lookupPrintServices(null, attrSet)[0].createPrintJob();
                    //PrintServiceLookup.lookupDefaultPrintService().createPrintJob();  

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(b, flavor, null);
       // PrintJobWatcher pjDone = new PrintJobWatcher(job);

        job.print(doc, null);
       // pjDone.waitForDone();
        System.out.println("Done !");
        }
        catch(javax.print.PrintException pex)
        {

            System.out.println("Printer Error " + pex.getMessage());
            return false;
        }
        catch(Exception e)
        {
        e.printStackTrace();
        return false;
        }


        return true;
    }




	
	
	public void init(){
		try{
			PrintOption p=new PrintOption();

            p.resetAll();
            p.initialize();
            //p.feedBack((byte)2);
//            p.color(0);
            p.chooseFont(3);
           // p.alignCenter();
            p.setText("BEST TOURS PTE LTD");
            p.newLine();
            p.chooseFont(2);
            
            p.setText("10 Anson Road, #03-05 Singapore , 079903");
            p.newLine();
            p.setText("Customer Service +65 8161 5060");
            p.newLine();
            
            
            p.chooseFont(3);
            p.addLineSeperator();
            p.newLine();
            p.setText("Customer Invoice");
            p.newLine();
            p.addLineSeperator();
            p.newLine();
            
            
            
            
            p.chooseFont(2);
            p.setText("Name\t\t:vin sri");
            p.newLine();
            p.setText("Hotel Name\t\t:Fragrance Riverside");
            p.newLine();
            p.setText("Hotel Address\t:20 Hongkong Street,");
            p.newLine();
            p.setText("\t\tSingapore");
            p.newLine();
            p.setText("Room No\t\t:999");
            p.newLine();
            p.setText("Order Date\t\t:26/07/2016");
            p.newLine();
            
            
            p.chooseFont(3);
            p.setText("Order ID\t\t2017");
            p.newLine();
            p.addLineSeperator();
            p.newLine();
            
            p.chooseFont(2);
            p.setText("Item desc\t\t:Singapore City Tour - Adult");
            p.newLine();
            p.setText("Quantity\t\t:2");
            p.newLine();
            p.setText("Total Price\t\t\t SGD 68");
            p.newLine();
            
            p.chooseFont(3);
            p.addLineSeperator();
            p.newLine();
            
            p.setText("Total Order Price\t\t SGD 68");
            p.newLine();
            p.addLineSeperator();
            
            
            p.chooseFont(2);
            p.newLine();
            p.setText("Delivery Type\t\t:-");
            p.newLine();
            p.setText("Delivery Date\t\t:-");
            p.newLine();
            p.setText("Delivery Time\t\t:-");
            p.newLine();
            p.setText("Payment Mode\t\t:ON SPOT");
            p.newLine();
            
            p.chooseFont(3);
            p.addLineSeperator();
            p.newLine();
            
            p.setText("NET\t\t\t SGD 68");
            
            
           
            p.feed((byte)3);
            p.finit();

        this.feedPrinter(p.finalCommandSet().getBytes());
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String... args){
		(new PrintExecutor()).init();
	}

}
