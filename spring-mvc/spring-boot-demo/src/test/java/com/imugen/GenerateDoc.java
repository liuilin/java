package com.imugen;

import static java.util.Arrays.asList;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.imugen.domain.TaxLine;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

/**
 * @author Liuqiang 2020/8/3 9:04
 */
@Slf4j
public class GenerateDoc {


    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        CronUtil.schedule("*/1 * * * * *", (Task) GenerateDoc::generateDocTack);
        // 支持秒级别定时任务...
        CronUtil.setMatchSecond(true);
        CronUtil.start();
        Thread.sleep(1000);
        CronUtil.stop();
    }


    /**
     * 数据库生成doc文档
     */
    public static void generateDocTack() {
//        List<String> list = asList("fscloud", "fscloud-product-eye-demo", "fscloud-service-area", "fscloud-service-enterprise",
//                        "fscloud-service-message", "fscloud-service-tenant", "fscloud-service-trade",
//                        "fscloud-service-user-admin", "fscloud-service-user-platform");
        List<String> list = asList("open_shop_dynamicfrom","open_shop_foundation","open_shop_legal_person","open_shop_management","open_shop_merchandise","open_shop_order","nacos");
        IntStream.range(0, list.size()).forEach(i -> {
//            String connConfig = "jdbc:mysql://localhost:3306/" + list.get(i) + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//            String connConfig = "jdbc:mysql://fscloud-middle-outter-test.mysql.cn-chengdu.rds.aliyuncs.com:3306/" + list.get(i)
            String connConfig = "jdbc:mysql://47.108.59.71:3306/" + list.get(i)
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            shouldAnswerWithTrue(connConfig);
        });


    }

    //        @Test
    public static void shouldAnswerWithTrue(String connConfig) {
        //数据源
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");

        hikariConfig.setJdbcUrl(connConfig);
//        hikariConfig.setUsername("root");
//        hikariConfig.setPassword("root");
//        hikariConfig.setJdbcUrl("jdbc:mysql://fscloud-middle-outter-test.mysql.cn-chengdu.rds.aliyuncs.com:3306/fscloud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
//        hikariConfig.setUsername("fscloud");
//        hikariConfig.setPassword("46i&jrfeg5tseI&k7#qtjKI(*^*ke");
        //开店宝test分支
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("u9ABW3U4");

        //设置可以获取tables remarks信息
        hikariConfig.addDataSourceProperty("useInformationSchema", "true");
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(5);
        DataSource dataSource = new HikariDataSource(hikariConfig);
        //生成配置
        EngineConfig engineConfig = EngineConfig.builder()
                //生成文件路径
                .fileOutputDir("C:\\Users\\Daniel\\Documents\\database-test")
                //打开目录
                .openOutputDir(true)
                //文件类型 HTML/WORD/MD
                .fileType(EngineFileType.MD)
                //生成模板实现
                .produceType(EngineTemplateType.freemarker).build();
        //忽略表
        ArrayList<String> ignoreTableName = new ArrayList<>();
//        ignoreTableName.add("test_user");
//        ignoreTableName.add("test_group");
        //忽略表前缀
        ArrayList<String> ignorePrefix = new ArrayList<>();
        ignorePrefix.add("test_");
        //忽略表后缀
        ArrayList<String> ignoreSuffix = new ArrayList<>();
        ignoreSuffix.add("_test");
        ProcessConfig processConfig = ProcessConfig.builder()
                //忽略表名
                .ignoreTableName(ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                //忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
        //配置
        Configuration config = Configuration.builder()
                //版本
                .version("1.0.0")
                //描述
                .description("数据库设计文档生成")
                //数据源
                .dataSource(dataSource)
                //生成配置
                .engineConfig(engineConfig)
                //生成配置
                .produceConfig(processConfig).build();
        //执行生成
        new DocumentationExecute(config).execute();
    }

    @Test
    void groupingByTest() {
        TaxLine t1 = new TaxLine("New York Tax", new BigDecimal("0.20"), new BigDecimal("20.00"));
        TaxLine t2 = new TaxLine("New York Tax", new BigDecimal("0.20"), new BigDecimal("20.00"));
        TaxLine t3 = new TaxLine("County Tax", new BigDecimal("0.30"), new BigDecimal("20.00"));
        List<TaxLine> taxes = new ArrayList<>();
        taxes.add(t1);
        taxes.add(t2);
        taxes.add(t3);
        List<TaxLine> flattened = taxes.stream()
                .collect(Collectors.groupingBy(
                        TaxLine::getTitle,
                        Collectors.groupingBy(
                                TaxLine::getRate,
                                Collectors.reducing(
                                        BigDecimal.ZERO,
                                        TaxLine::getPrice,
                                        BigDecimal::add))))
                .entrySet()
                .stream()
                .flatMap(e1 -> e1.getValue()
                        .entrySet()
                        .stream()
                        .map(e2 -> new TaxLine(e1.getKey(), e2.getKey(), e2.getValue())))
                .collect(Collectors.toList());
        flattened.forEach(System.out::println);

    }

    @Test
    void n() {
        List<List<String>> nestedList = asList(
                asList("one:one"),
                asList("two:one", "two:two", "two:three"),
                asList("three:one", "three:two", "three:three", "three:four"));
        List<String> collect = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        collect.forEach(System.out::println);


    }

    /*public static void main(String[] args) {
                    List<String> list = Arrays.asList("fscloud", "fscloud-product-eye-demo", "fscloud-service-area", "fscloud-service-enterprise", "fscloud-service-tenant", "fscloud-service-trade");
            //        List<String> list = Arrays.asList("c", "test", "test1");111

                    IntStream.range(0, list.size()).forEach(i -> {
            //            String connConfig = "jdbc:mysql://localhost:3306/" + list.get(i) + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                        String connConfig = "jdbc:mysql://fscloud-middle-outter-test.mysql.cn-chengdu.rds.aliyuncs.com:3306/" + list.get(i) + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                        System.out.println("str = " + connConfig);
                        shouldAnswerWithTrue(connConfig);
                    });

                }*/
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public String orElseBenchmark() {
        String str = null;
//        return Optional.ofNullable(str).orElse(getRandomName());
        return Optional.ofNullable(str).orElseGet(() -> getRandomName());
    }

    public String getRandomName() {
        List<String> names = asList("hh", "xixi", "la", "lin");
        System.out.println("getRandomName() method - start");

        Random random = new Random();
        int index = random.nextInt(4);

        System.out.println("getRandomName() method - end");
        return names.get(index);
    }

    @Test
    void name() {
        String s = orElseBenchmark();
        System.out.println("s = " + s);
    }

}