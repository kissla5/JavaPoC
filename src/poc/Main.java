/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.commons.lang3.StringUtils;
import org.quartz.CronExpression;
//import test.Root;
import poc.thread.*;

/**
 * @author k_laszlo
 */
public class Main {

    private final static String INDEX_GENERAL_ERROR = "indexjava.generalError";

    // private final static Logger log = Logger.getLogger(Main.class);
    private static Callable<Object> callable = new Callable<Object>() {

        @Override
        public Object call() throws Exception {
            return null;
        }
    };
    private static Future<Object> provisionerServiceFuture = null;
    private static FutureTask<Object> provisionerServiceTask = null;
    private static ExecutorService executor = Executors.newFixedThreadPool(1);

    private static final String HEADER_ID_PREFIX = "columntable";
    private static final String tableId = "userGrid";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("hello");
    }
    
    public static void testLabel() {
        System.out.println("");
        
        int[] a = {1,2};
        test2:
        switch (a[0]) {
            case 1:
                test1:
                for (int b : a) {
                    int test1 = 1, test2;
                    System.out.println("" + test1);
                    break test2;
                }
//                break test2;
                System.out.println("abc");
        }
    }
    public static void testArrayInit() {
        int[] a = {1,2};
        A[] b = new B[2];
    }
    
    public static void castingPrim() {
        double a = 3L;
        char c = 'a';
        double cc = c;
        System.out.println("c: " + cc);
    }

    public static void orderOfAssigment() {
//                int a=b+c, b=2, c=1;
//        System.out.println("a: " + a);
//        System.out.println("b: " + b);
//        System.out.println("c: " + c);
    }
    
    public static void multiCast() {
        A c = (C)(Object)(C)new C();
        C a = new C();
//        I o = (I)a;
//        a = (C)o;
        TreeSet<C> treeSet = new TreeSet<C>();
        treeSet.add(a);
        System.out.println("multicast: " + a.toString());
    }
    
    public static void printfTest() {
        System.out.printf("%2$15.2f %1$s%n", "a", 14.13213f);
    }
    
    public static void regexpTest() {
//        Pattern compile = Pattern.compile("\\b\\D\\w+@\\w+\\.com\\b");
        Pattern compile = Pattern.compile("\\D\\W*");
//        Matcher matcher = compile.matcher("abc_0dfgh@ijk.com");
        Matcher matcher = compile.matcher("abc- 0 dfgh@ijk.com");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    
    public static void primitives() {
        int a[] = new int[2];
        int i = 3;
        boolean b = (a instanceof Object);
        System.out.println("result: " + b);
        String ss[] = {"A", "B"};
        Object oo[] = ss;
        System.out.println("oo: " + oo);
    }
    
    public static void testSuppressed2() throws Exception {
        try(SupressedResource sr = new SupressedResource()) {
            throw new RuntimeException("test");
        }
        catch (Exception ex) {
//            System.out.println("exception: " + ex);
//            for (Throwable suppressed : ex.getSuppressed()) {
//                System.out.println("supressed: " + suppressed);
//            }
            throw ex;
        }
//        finally {
//            throw new RuntimeException("And now, something completly different!");
//        }
//        testSuppressed("dist/PoC.jar", "abcd.abc");
    }

    public static void testSuppressed(String zipFileName,
                                           String outputFileName)
                                           throws java.io.IOException {

        java.nio.charset.Charset charset =
             java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath =
             java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with 
        // try-with-resources statement

        try (
            java.util.zip.ZipFile zf =
                 new java.util.zip.ZipFile(zipFileName);
            java.io.BufferedWriter writer = 
                java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (java.util.Enumeration entries =
                                    zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName =
                     ((java.util.zip.ZipEntry)entries.nextElement()).getName() +
                     newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
//                System.out.println("deleted: " + new File(outputFileName).delete());
//                System.out.println("deleted2: " + new File(zipFileName).delete());
//                zf.close();
            }
        }
        catch (Exception ex) {
//            if (true)
//            throw new RuntimeException("test", ex);
            System.out.println("exception: " + ex);
            for (Throwable suppressed : ex.getSuppressed()) {
                System.out.println("supressed: " + suppressed);
            }
        }
    }

    public static void makeGeneric() {
        Integer integer = new Integer(2);
        List<Object> listObj = new ArrayList<>();
        listObj.add(new Object());
        List<? super Number> listNum = new ArrayList<>();
        listNum.add(integer);
        System.out.println("test gen: " + listNum);
        Collections.copy(listObj, listNum);
        copy(new ArrayList<Object>() {}, new ArrayList<Integer>() {});
        System.out.println("list obj: " + listObj);
//        try {
//            List<? super Number> listNum2;
//            List<Object> listObj2;
//            Method m = Collections.class.getMethod("copy", listObj2.getClass(), listNum2.getClass());
//            Type[] genericParameterTypes = m.getGenericParameterTypes();
//            for (int i = 0; i < genericParameterTypes.length; i++) {
//                 if( genericParameterTypes[i] instanceof ParameterizedType ) {
//                            Type[] parameters = ((ParameterizedType)genericParameterTypes[i]).getActualTypeArguments();
//                 }
//            }
//        } catch (NoSuchMethodException | SecurityException noSuchMethodException) {
//            noSuchMethodException.printStackTrace();
//        }
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        int srcSize = src.size();
    }
    
    public static void makeSemaphore() {
        Semaphore s = new Semaphore(2, false);
        new ATMPerson(s, "T1");
        new ATMPerson(s, "T2");
        new ATMPerson(s, "T3");
        new ATMPerson(s, "T4");
        new ATMPerson(s, "T5");
    }
    public static void makeDescriptiveColor() {
        System.out.println(StatusReporter.getDesciptiveColor(new Shape.Color(1, 2, 3)).toString2());
        System.out.println(StatusReporter.getDesciptiveColor(new Shape.Color(1, 2, 3)).toString());
    }
    
    public static void makeCoffee() {
        Exchanger<String> msg = new Exchanger<>();
        new Duke(msg).start();
        CoffeeMachine coffeeMachine = new CoffeeMachine(msg);
        Waiter waiter = new Waiter();
        coffeeMachine.start();
        waiter.start();
    }

    public static void datePattern() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y Y d D F W E");
        Date date = new Date(115, 11, 26);
        System.out.println("Date: " + simpleDateFormat.format(date) + "/" + date);
    }

    public static void localeCountryHU() {
        System.out.println(new Locale("hu", "HU").getDisplayCountry(new Locale("hu", "HU")));
        System.out.println(new Locale("hu", "HU").getDisplayCountry(new Locale("ru")));
    }

    public static void testGetResourceFromJar() {
        URL resource = Main.class.getResource("/META-INF");
        System.out.println("resource: " + resource.toExternalForm());
    }

    public static void testLastSubstring() {
        String id = "managed/user/test";
        String newId = id.substring(id.lastIndexOf("/") + 1);
        System.out.println("id: " + id + "; new id: " + newId);
    }

    public static void buildXPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(".//*[@id='").append(HEADER_ID_PREFIX).append(tableId).append("']");
        sb.append("/div[");
        sb.append("contains(@class, 'jqx-grid-columngroup-header')");
        sb.append("]");
        sb.append("[").append(1).append("]");
        sb.append("/*//div[");
        sb.append("contains(@class, 'pull-left')");
        sb.append("]");
        System.out.println("XPATH:" + sb.toString());
    }

    public static void testParseDate() {
        System.out.println("" + DatatypeConverter.parseDate("2014-01-01").getTime());
    }

    public static void testFutureTask() {
        Thread thread = new Thread(new Runnable() {

            public void run() {
                provideFuturetask();
            }
        });
        thread.start();

        executeFuturetask();
    }

    public static void executeFuturetask() {
        // executor.execute(provisionerServiceTask);
        provisionerServiceFuture = executor.submit(callable);
    }

    public static void provideFuturetask() {

        // provisionerServiceTask = new FutureTask<Object>(new Callable<Object>() {
        //
        // @Override
        // public Object call() throws Exception {
        // return null;
        // }
        // });
        try {
            provisionerServiceFuture.get(20, TimeUnit.SECONDS);
            // provisionerServiceTask.get(20, TimeUnit.SECONDS);
        } catch (Exception interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            provisionerServiceTask = null;
            provisionerServiceFuture = null;
        }

    }

    public static void testTryCatchFinal() {
        try {
            try {
                throw new RuntimeException("an expcetion");
            } finally {
                System.out.println("It's final!");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("It's final2!");
        }
    }

    public static void testNowInISODATESTRING() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        System.out.println("now: " + nowAsISO);
    }

    public static void testRexexp() {
        System.out.println("JSESSIONID=c26eez8i0ynh1h124kxme494t;".split("JSESSIONID=")[1].split("[;]")[0]);
    }

    public static void testSubstring() {
        System.out.println("Hello!".substring(1, 3));
    }

    public static <T extends A> void callWithAB(T a) {
        callWithABs((B) a);
    }

    public static void callWithABs(A a) {
        System.out.println("It's A!");
    }

    public static void callWithABs(C a) {
        System.out.println("It's C!");
    }

    public static void callWithABs(B b) {
        System.out.println("It's B!");
    }

    public static void imageReader() throws InterruptedException, IOException {
        Iterator<ImageReader> imageReadersByMIMEType = ImageIO.getImageReadersByMIMEType("image/jpeg");
        while (imageReadersByMIMEType.hasNext()) {
            ImageReader next = imageReadersByMIMEType.next();
            System.out.println("test: " + next);
            InputStream stream = new ByteArrayInputStream("test".getBytes("UTF-8"));
            next.setInput(ImageIO.createImageInputStream(stream));
            // next.setInput(null);
            next.dispose();
            // next = null;
            System.gc();

        }

        Thread.sleep(15000);

    }

    public static void calDays() {
        System.out.println("first day: " + Calendar.getInstance(new Locale("hu", "HU")).getFirstDayOfWeek());
        System.out.println("first day: " + Calendar.getInstance(new Locale("en", "US")).getFirstDayOfWeek());
        System.out.println("last day: " + (7 + Calendar.getInstance(new Locale("hu", "HU")).getFirstDayOfWeek()) % 7);
        System.out.println("last day: " + (7 + Calendar.getInstance(new Locale("en", "US")).getFirstDayOfWeek()) % 7);
        System.out.println("saturday: " + Calendar.getInstance(new Locale("en", "US")).get(Calendar.SUNDAY));
        System.out.println("first day: " + Calendar.getInstance(new Locale("hu", "HU")).getActualMaximum(Calendar.DAY_OF_WEEK));
        System.out.println("first day: " + Calendar.getInstance(new Locale("en", "US")).getActualMaximum(Calendar.DAY_OF_WEEK));
        System.out.println("first day: " + Calendar.getInstance(new Locale("en", "US")).getActualMaximum(Calendar.DATE));
        System.out.println("first day: " + Calendar.getInstance(new Locale("hu", "HU")).getActualMinimum(Calendar.DAY_OF_WEEK));
        System.out.println("first day: " + Calendar.getInstance(new Locale("hu", "HU")).getGreatestMinimum(Calendar.DAY_OF_WEEK));
        System.out.println("first day: " + Calendar.getInstance(new Locale("hu", "HU")).getLeastMaximum(Calendar.DAY_OF_WEEK));
    }

    public static void dayLightSavingTimeHungary() {
        Calendar cal = Calendar.getInstance();
        cal.set(2013, 2, 31, 1, 59);
        System.out.println("time before saving:" + cal.getTime());
        // cal.add(Calendar.HOUR_OF_DAY, 10);
        cal.add(Calendar.MINUTE, 1);
        System.out.println("time after saving:" + cal.getTime());
        cal.set(2013, 2, 31, 1, 59);
        System.out.println("is time saving:" + TimeZone.getDefault().inDaylightTime(cal.getTime()));
        cal.setTimeInMillis(cal.getTimeInMillis() + 60000);
        System.out.println("time after saving2:" + cal.getTime());
        System.out.println("is time saving:" + TimeZone.getDefault().inDaylightTime(cal.getTime()));

        cal.set(2013, 2, 30, 1, 59);
        long start = cal.getTimeInMillis();
        // start-=(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET));
        long startOffset = (cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET));
        System.out.println("date: " + cal.getTime() + ", offset: " + (cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)));
        cal.set(2013, 3, 2, 1, 59);
        long end = cal.getTimeInMillis();
        // end-=(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET));
        long endOffset = (cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET));
        System.out.println("date: " + cal.getTime() + ", offset: " + (cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)));
        System.out.println("diff: " + ((end / 60000 - start / 60000) - (startOffset / 60000 - endOffset / 60000)));
    }

    public static void calendarStringToMillis(String calendar) throws ParseException {
        SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(parserSDF.parse(calendar));
        for (int i = 0; i < 15; i++) {
            cal.add(Calendar.DAY_OF_YEAR, 7);
            System.out.println(cal.getTimeInMillis() + " (" + cal.getTime() + ")");
        }
    }

    public static void testEndOfWeekOnFri() throws ParseException {
        Calendar beginingOfCW = Calendar.getInstance();
        beginingOfCW.add(Calendar.DAY_OF_WEEK, beginingOfCW.getFirstDayOfWeek() - beginingOfCW.get(Calendar.DAY_OF_WEEK));
        Calendar endOfCW = (Calendar) beginingOfCW.clone();
        endOfCW.add(Calendar.DAY_OF_YEAR, 4);
        Date endOfCWDate = endOfCW.getTime();
        System.out.println("end of cw: " + endOfCWDate);
        SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss zzz");
        System.out.println("formet eofcw: " + parserSDF.format(endOfCWDate));
    }

    public static void testSimpleDateParse2() throws ParseException {
        SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzzz");
        System.out.println("time: " + parserSDF.parse("ecdomain\\dehmics"));
    }

    public static void testSimpleDateParse() throws ParseException {
        SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss zzzz");
        System.out.println("time: " + parserSDF.parse("2013-01-01T12:41:40 CET"));
    }

    public static void testSystemProp() {
        System.out.println("Glassfiss instance in the container: " + System.getProperty("com.sun.aas.instanceRoot"));
        System.out.println("Java version anywhere: " + System.getProperty("java.version"));
    }

//    public static void testJAXB() {
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance("test");
//            Schema schema = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File("test.xsd"));
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            unmarshaller.setSchema(schema);
//            // System.out.println("" + unmarshaller.unmarshal(new File("test.xml")));
//            Root unmarshal = (Root) unmarshaller.unmarshal(new File("test.xml"));
//            System.out.println("test: " + unmarshal.getText());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void testQuartz() throws ParseException {
        Date date = new Date();// new Date(113, 04, 27, 15, 0);
        System.out.println("date: " + date);
        CronExpression ce = new CronExpression("* * 7-8/1,10-11/1 ? * 2#3");
        System.out.println("final: " + ce.getFinalFireTime());
        System.out.println("ISB: " + ce.isSatisfiedBy(date));
        System.out.println("NVTA: " + ce.getNextValidTimeAfter(date));
        System.out.println("NIVTA: " + ce.getNextInvalidTimeAfter(ce.getNextValidTimeAfter(date)));
        System.out.println("NVTA: " + ce.getNextValidTimeAfter(ce.getNextInvalidTimeAfter(ce.getNextValidTimeAfter(date))));
        System.out.println("NIVTA: "
                + ce.getNextInvalidTimeAfter(ce.getNextValidTimeAfter(ce.getNextInvalidTimeAfter(ce.getNextValidTimeAfter(date)))));
    }

    public static void instaceOf() {
        System.out.println(null instanceof String);
    }

    public static void testAlg() {
        int a = 8;
        a -= --a - a--;

        System.out.println("a: " + a);
        a = 8;
        System.out.println("a: " + --a);
        a = 8;
        System.out.println("a: " + a--);
        a = 8;
        System.out.println("a: " + (--a - a));
        a = 8;
        System.out.println("a: " + (--a - a--));
        a = 8;
        System.out.println("a: " + (a -= --a - a));
        a = 8;
        System.out.println("a: " + (a -= --a - a--));
        a = 8;
        System.out.println("a: " + (a -= a - a--));
    }

    public static void testGeneric() {
        new GenericTestChild();
        new GenericTestChild2();
        new GenericTest<MyClass>();
    }

    public static void testNullSwitch() {
        TestEnum e = null;
        switch (e) {
            case TEST1:
                System.out.println("TEST1 selected");
            default:
                System.out.println("Default selected");
        }
    }

    public static void testBooleanParse() {
        System.out.println("Boolean: " + Boolean.parseBoolean("tRue"));
        System.out.println("Boolean: " + Boolean.parseBoolean("0"));
        System.out.println("Boolean: " + Boolean.valueOf("tRue"));
    }

    public static void testFileExists() {
        File a = new File("/tmp/a.txt");

        System.out.println("a: " + a.getName());
        System.out.println("a file: " + a.isFile());
        System.out.println("a dir: " + a.isDirectory());
        System.out.println("a hidden: " + a.isHidden());
        System.out.println("a absolute: " + a.isAbsolute());
        System.out.println("a absolute: " + a.getAbsolutePath());
    }

    public static void testCutFileName() {
        String originalName = "c:/as/df";
        String winFileName = StringUtils.substringAfterLast(originalName, "\\");
        if (StringUtils.isEmpty(winFileName)) {
            winFileName = originalName;
        } else {
            // name contain the new file name
        }

        String name = StringUtils.substringAfterLast(winFileName, "/");
        if (StringUtils.isEmpty(name)) {
            name = winFileName;
        } else {
            // name contain the new file name
        }

        System.out.println("Last: " + name);
    }

    public static void mapAndNullValue() {
        Map<String, Integer> filesDuringProcessing = new HashMap<String, Integer>();
        System.out.println("a != 1" + (filesDuringProcessing.get("a") == 1));

        filesDuringProcessing.put("a", 1);
        System.out.println("a != 1" + (filesDuringProcessing.get("a") != 1));

        filesDuringProcessing.put("a", filesDuringProcessing.get("a") + 1);

        System.out.println("a != 1" + (filesDuringProcessing.get("a") != 1));

        System.out.println("a: " + filesDuringProcessing.get("a"));
    }

    private static void upperCase() {
        System.out.println("Upper: " + "a-Béíű".toUpperCase());
    }

    private static void classEquals() {
        // List l = Arrays.asList(Calendar.getInstance());
        List l = new ArrayList();
        l.add(null);
        List l2 = Arrays.asList(2L);

        // System.out.println("Class l:" + l.get(0).getClass());
        System.out.println("Class l2:" + l2.get(0).getClass());
        if (l.get(0) instanceof Calendar) {
            System.out.println("ok");
        } else {
            System.out.println("not ok");
        }
        // if (GregorianCalendar.class.equals(l.get(0).getClass())) {
        // System.out.println("ok");
        // } else {
        // System.out.println("not ok");
        // }
        if (GregorianCalendar.class.equals(l2.get(0).getClass())) {
            System.out.println("ok");
        } else {
            System.out.println("not ok");
        }
    }

    private static Long getPageNumber() {
        double rowNum = 11;
        int rowNumLimit = 10;

        return new Double(Math.ceil(rowNum / rowNumLimit)).longValue();
    }

    private static String getKey(String source) {
        String[] split = source.split("[.]");
        if (split.length > 1) {
            return split[1];
        } else {
            return source;
        }
    }

    private static String deleteEndAnd() {
        StringBuilder b = new StringBuilder();

        b.append("where a");

        b.append(".and.");

        b.delete(b.length() - 5, b.length());

        return b.toString();
    }

    private static void hackInteger() {
        (new ValueMunger()).start();

        Integer a = 2;
        Integer b = 3;

        for (int i = 0; i < 100; i++) {

            System.out.println(a + b);
            try {
                Thread.sleep(100);
            } catch (Throwable t) {
            }
        }

    }

    private static boolean wrongDateOrder(Calendar... calendars) {
        if (calendars == null || calendars.length == 0 || calendars[0] == null) {
            return false;
        }

        for (int i = 0; i < calendars.length - 1; i++) {
            Calendar actualCalendar = calendars[i];
            Calendar nextCalendar = calendars[i + 1];

            System.out.println("actual: " + actualCalendar.getTime());
            System.out.println("next: " + nextCalendar.getTime());
            if (nextCalendar == null) {
                return false;
            }

            if (!actualCalendar.before(nextCalendar)) {
                return false;
            }
        }

        return true;
    }

    private static void formatIt() {
        System.out.println("Formatted number: " + NumberFormat.getInstance(new Locale("hu", "HU")).format(1411.3));

        System.out.println(MessageFormat.format("{0,number} <{1,choice,0#=|1#} {2} {3,choice,0#'<'|1<}{3,choice,0#'='|0<} {4,number}", 0, 1, 10, 3));
        System.out.println("Formatter: " + String.format(new Locale("hu", "HU"), "%1$s, %2$d", 0.21, 1001212));
    }

    private static String generateURL(String page, Map<String, String> params) {
        StringBuilder url = new StringBuilder(page);
        boolean firstParam = true;

        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> param : params.entrySet()) {
                if (firstParam) {
                    url.append("?" + param.getKey() + "=" + param.getValue());
                    firstParam = false;
                } else {
                    url.append("&" + param.getKey() + "=" + param.getValue());
                }
            }
        }

        return url.toString();
    }

    private static boolean isAny(Boolean b) {
        return b == true;
    }

    // private static void testHistogram() {
    // XMLVersionedConfigBean xMLVersionedConfigBean = new XMLVersionedConfigBean();
    // xMLVersionedConfigBean.initHistogramComputingDTOs();
    // List<HistogramComputingDTO> histogramComputingDTOList =
    // xMLVersionedConfigBean.getHistogramComputingDTOList(xMLVersionedConfigBean.getDataSourceId("202", "ioruntime"),
    // Calendar.getInstance());
    // System.out.println(
    // "HistogramComputingDTO by measurement name1: " + histogramComputingDTOList);
    // // Map<String, List<HistogramComputingDTO>> histogramComputingDTOsByMeasurementName = MeasurementInformation.
    // // getHistogramComputingDTOsByVersion(Calendar.getInstance()).
    // // getHistogramComputingDTOsByMeasurementName();
    // // System.out.println(
    // // "HistogramComputingDTO by measurement name: " + histogramComputingDTOsByMeasurementName);
    //
    // }
    private static void testMap() {
        Map<String, String> hashMap = new HashMap<String, String>() {

            {
                put("a", "b");
                put("c", "b");
                put("ad", "b");
            }
        };
        ArrayList<String> arrayList = new ArrayList<String>() {

            {
                add("a");
                add("b");
            }
        };
        Calendar gregorianCalendar = new GregorianCalendar() {

            {
                add(YEAR, -1);
            }
        };

        MyClass myClass = new MyClass() {

            {
                setNumber(42);
            }
        };

        System.out.println("Number: " + myClass.getNumber());

        System.out.println("ArrayList: " + arrayList);
        System.out.println("HashMap: " + hashMap);
        System.out.println("Calendar: " + gregorianCalendar.getTime());
    }

    private static void testMultiThreadSingleton() {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {

                public void run() {
                    System.out.println("i [" + this + "]: " + MySingleton.getInstance().add());
                }
            }).run();
        }
    }

    private static void testAll() {
        // System.out.println("class: " + new Main().getClass().getName());
        // System.out.println("Format: " + String.format("%1$s (%2$s <%3$s>)", "a", "", null));
        //
        // System.out.println("Isnull: " + isAny(null));
        // Locale userLocaleFromConfig = Locale.CANADA;
        //
        // Map<String, String> params = null; //new HashMap<String, String>();
        // // params.put("msg", INDEX_GENERAL_ERROR);
        // // params.put("userLocale", (userLocaleFromConfig != null ? userLocaleFromConfig.toString() : ""));
        // // params.put("automatedErrorParameter", "true");
        //
        // String redirectURL = generateURL("/error.jsp", params);
        //
        // System.out.println("redirect to: " + redirectURL);
        /*
         * String[] documentURIFragmants = "".split("/");
         * System.out.println(documentURIFragmants[documentURIFragmants.length - 1]);
         * System.out.println("Path:" + System.getProperty("sjsas.url") + "/" + System.getProperty("sun-web-app.context-root") + "/" +
         * System.getProperty("com.sun.aas.instanceRoot"));
         * String imgSrc="d.h";
         * String tempDocumentURL="a/b/c.f";
         * String[] tempDocumentURLSplit = tempDocumentURL.split("/");
         * String tempDocumentURLReplaced = tempDocumentURL.replaceAll(tempDocumentURLSplit[tempDocumentURLSplit.length - 1], "");
         * String imgURL = tempDocumentURLReplaced + imgSrc;
         * System.out.println("imgURL: " + imgURL);
         */
        /*
         * System.out.println("123".replaceAll("(3)$", ""));
         * URL url = new URL("file:///a/b/c");
         * System.out.println("URL getProtocol: " + url.getProtocol());
         * System.out.println("URL getHost: " + url.getHost());
         * System.out.println("URL getAuthority: " + url.getAuthority());
         * System.out.println("URL getPath: " + url.getPath());
         * System.out.println("URL getFile: " + url.getFile());
         * System.out.println("URL getQuery: " + url.getQuery());
         * System.out.println("URL getRef: " + url.getRef());
         * System.out.println("URL getRef: " + url.toString());
         * System.out.println("URL getUserInfo: " + url.getUserInfo());
         * System.out.println("end");
         * Map myMap = new HashMap();
         * Map myMap1 = new HashMap();
         * myMap1.put("myMap1", "myMapValue");
         * myMap1.put("myMap1", "myMapValue");
         * Map myMap2 = new HashMap();
         * myMap2.put("myMap2", "myMapValue");
         * myMap.put("hello1", myMap1);
         * myMap.put("hello1", myMap2);
         * System.out.println("myMap: " + myMap);
         * System.out.println("Formatter: " + String.format("%1$s - %2$s - %3$s /...", "a", null, "c"));
         */
        // testMultiThreadSingleton();
        // testHistogram();
        // testMap();
        //
        // String s = null;
        // if (s == null) {
        // s = "";
        // }
        // s += "hello";
        // System.out.println("S: " + s);
        // Calendar c1 = Calendar.getInstance();
        // c1.add(Calendar.DAY_OF_MONTH, 1);
        // Calendar c2 = Calendar.getInstance();
        // c2.add(Calendar.DAY_OF_MONTH, 2);
        // Calendar c3 = Calendar.getInstance();
        // c3.add(Calendar.DAY_OF_MONTH, 3);
        // Calendar c4 = Calendar.getInstance();
        // c4.add(Calendar.DAY_OF_MONTH, 4);
        // Calendar c5 = Calendar.getInstance();
        // c5.add(Calendar.DAY_OF_MONTH, 5);
        //
        // System.out.println("Order result: " + wrongDateOrder(c1, c2));
        // float i = 2147483647;
        //
        // System.out.println("i: " + (i - 64));
        // System.out.println("getkey: " + getKey("o.eventKind"));
        // System.out.println("getPageNumber: " + getPageNumber());
        // Map<String, List> filterMap;
        // filterMap.put("version", Arrays.asList(new Calendar[]{version}));
        // List<Long> asList = Arrays.asList(1l);
        // System.out.println("list: " + asList);
        // NumberFormat.getInstance().
        // System.out.println("" + );
        // classEquals();

        // upperCase();
        // mapAndNullValue();
        // testBooleanParse();
        // testNullSwitch();
        // testGeneric();
        // instaceOf();
        // testJAXB();
        // testSystemProp();
        // testSimpleDateParse2();
        // testEndOfWeekOnFri();
        // calendarStringToMillis("2012-12-10 00:00:00");
        // dayLightSavingTimeHungary();
        // int[] a = new int[1];
        // int i = -10;
        // a[i] = 10;
        // System.out.println("i: " + i);
        // System.out.println("i: " + a[i]);
        // calDays();
        // log.error("Hello");
        // imageReader();
        // callWithAB(new C());
        // testNowInISODATESTRING();
        testTryCatchFinal();

        testFutureTask();
    }
}
