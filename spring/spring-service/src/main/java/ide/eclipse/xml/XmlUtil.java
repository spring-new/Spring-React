package ide.eclipse.xml;

import ide.eclipse.entity.IMType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: 利用反射和JDOM解析xml成bean/List
 * @Date: 2018/1/22 16:06
 */
public class XmlUtil {

    /**
     * xml转换成bean
     *
     * @param xml
     * @param obj
     * @return
     */
    public static Object xmlToBean(String xml, Class obj) {
        SAXBuilder builder = new SAXBuilder();
        Field[] fields = obj.getDeclaredFields();
        String beanName = obj.getSimpleName();
        try {
            Object object = Class.forName(obj.getName()).newInstance();
            Document doc = builder.build(new StringReader(xml));
            Element books = doc.getRootElement();
            List booklist = books.getChildren(beanName);
            for (Iterator iter = booklist.iterator(); iter.hasNext(); ) {
                Element book = (Element) iter.next();
                for (int j = 0; j < fields.length; j++) {
                    fields[j].setAccessible(true);
                    if (!fields[j].toString().contains("final")) {
                        fields[j].set(object, book.getChildTextTrim(fields[j].getName()) == null ? "" : book.getChildTextTrim(fields[j].getName()));
                    }
                }
            }
            System.out.println(fields.toString());
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * xml转换成list
     *
     * @param xml
     * @param obj
     * @return
     */
    public static List<?> xmlToList(String xml, Class obj) {
        SAXBuilder builder = new SAXBuilder();
        Field[] fields = obj.getDeclaredFields();
        String beanName = obj.getSimpleName();
        try {
            Object object = Class.forName(obj.getName()).newInstance();
            List<Object> list = new ArrayList<Object>();
            Document doc = builder.build(new StringReader(xml));
            Element books = doc.getRootElement();
            List booklist = books.getChildren(beanName);
            for (Iterator iter = booklist.iterator(); iter.hasNext(); ) {
                Element book = (Element) iter.next();
                for (int j = 0; j < fields.length; j++) {
                    fields[j].setAccessible(true);
                    if (!fields[j].toString().contains("final")) {
                        fields[j].set(object, book.getChildTextTrim(fields[j].getName()) == null ? "" : book.getChildTextTrim(fields[j].getName()));
                    }
                }
                list.add(object);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * bean转换成xml
     */
    public static String beanToXmls(Object obj) {
        Class t = null;
        if (obj instanceof IMType){
            t=IMType.class;
        }
         /*t = (Class) obj.getClass();*/
        Field[] fields = t.getDeclaredFields();
        StringBuffer buffer = new StringBuffer();
        buffer.append("<Data><IMType>");
        try {
            Object object = Class.forName(obj.getClass().getName()).newInstance();
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                String val = fields[j].get(obj) == null ? "" : fields[j].get(obj) + "";
                buffer.append("<" + fields[j].getName() + ">" + val + "</" + fields[j].getName() + ">\n");
            }
            buffer.append("</IMType></Data>");
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        List<IMType> o = (List<IMType>) xmlToList(xml, IMType.class);
        System.out.println(o);
        System.out.println(o.get(0).getCOEL());
        for (IMType c : o) {
            String str = beanToXmls(o);
            System.out.println(str);
            List<IMType> b = (List<IMType>) xmlToList(str, IMType.class);
            System.out.println("b:" + b);
        }



    }

    private static String xml = "<Data>\n" +
            "\t<IMType>\n" +
            "\t\t<InspectionNum>4416020120130730160935272</InspectionNum>\n" +
            "\t\t<StationCode>441600002</StationCode>\n" +
            "\t\t<HCEL>0.2</HCEL>\n" +
            "\t\t<HCER>0.2</HCER>\n" +
            "\t\t<HCED>1</HCED>\n" +
            "\t\t<COEL>0.2</COEL>\n" +
            "\t\t<COER>0.2</COER>\n" +
            "\t\t<COED>1</COED>\n" +
            "\t\t<NOXEL>0.2</NOXEL>\n" +
            "\t\t<NOXER>0.2</NOXER>\n" +
            "\t\t<NOXED>1</NOXED>\n" +
            "\t\t<HCNOXEL>0.2</HCNOXEL>\n" +
            "\t\t<HCNOXER>0.2</HCNOXER>\n" +
            "\t\t<HCNOXED>1</HCNOXED>\n" +
            "\t</IMType>\n" +
            "</Data> ";
}