package com.ics.pos.restaurant.icsrestaurant.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ics.pos.restaurant.icsrestaurant.connect.DatabaseConnection;
import com.ics.pos.restaurant.icsrestaurant.model.PosuserBean;

public class PosuserRepository implements RepositoryInterface<PosuserBean> {

    private static final Logger logger = Logger.getLogger(PosuserRepository.class.getName());

    @Override
    public PosuserBean create(PosuserBean bean) {
        String sql = "INSERT INTO posuser (UserName, Password, Name, UserGroup, OnACT, MacNo, Sale1, Sale2, Sale3, Sale4, Sale5, Sale6, Sale7, Sale8, Sale9, Sale10, Sale11, Sale12, Sale13, Sale14, Sale15, Sale16, Sale17, Sale18, Sale19, Sale20, Sale21, Sale22, Sale23, Sale24, Sale25, Sale26, Sale27, Sale28, Sale29, Sale30, Sale31, Sale32, Sale33, Sale34, Sale35, Sale36, Cont0, Cont1, Cont2, Cont3, Cont4, Cont5, Cont6, Cont7, Cont8, Cont9, Cont10, Cont11, Cont12, Cont13, Cont14, Cont15, Stock0, Stock0_1, Stock1, Stock2, Stock3, Stock4, Stock5, Stock6, Stock7, Stock8, Stock9, Stock10, Stock11, Stock12, Stock13, Stock14, Stock15, Stock16, Stock17, Stock18, Stock19, Stock20, Stock21, Stock22, Stock23, Stock24, Stock25, Stock26, Stock27, Stock28, Stock29, Stock30, Stock31, Stock32, Stock33, Stock34, Stock35, Stock36, Stock37, Stock38, Stock39, Stock40, Stock41, Stock42, Stock43, Stock44, Stock45, Stock46, Stock47, Stock48, Stock49, Stock50, Stock51, Stock52, Stock53, Stock54, Stock55, Stock56, Stock57, Stock58, Stock59, Stock60, Stock61, Stock62, Stock63, Stock64, Stock65, Stock66, Stock67, Stock68, Stock69, Stock70, Stock71, Stock72, Stock73, Stock74, Cont16, Cont17, Cont18, Cont19, Cont20, Cont21, Cont22, Cont23, Cont24, Cont25, Cont26, Cont27, Cont28, Cont29, Cont30, Cont31, Cont32, Cont33, Cont34, Cont35, Cont36, Cont37, Cont38, Cont39, Cont40, Cont41, Cont42, Cont43, Cont44, Cont45, Cont46, Cont47, Sale37, Sale38) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, bean.getUsername());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setString(4, bean.getUsergroup());
            ps.setString(5, bean.getOnact());
            ps.setString(6, bean.getMacno());
            ps.setString(7, bean.getSale1());
            ps.setString(8, bean.getSale2());
            ps.setString(9, bean.getSale3());
            ps.setString(10, bean.getSale4());
            ps.setString(11, bean.getSale5());
            ps.setString(12, bean.getSale6());
            ps.setString(13, bean.getSale7());
            ps.setString(14, bean.getSale8());
            ps.setString(15, bean.getSale9());
            ps.setString(16, bean.getSale10());
            ps.setString(17, bean.getSale11());
            ps.setString(18, bean.getSale12());
            ps.setString(19, bean.getSale13());
            ps.setString(20, bean.getSale14());
            ps.setString(21, bean.getSale15());
            ps.setString(22, bean.getSale16());
            ps.setString(23, bean.getSale17());
            ps.setString(24, bean.getSale18());
            ps.setString(25, bean.getSale19());
            ps.setString(26, bean.getSale20());
            ps.setString(27, bean.getSale21());
            ps.setString(28, bean.getSale22());
            ps.setString(29, bean.getSale23());
            ps.setString(30, bean.getSale24());
            ps.setString(31, bean.getSale25());
            ps.setString(32, bean.getSale26());
            ps.setString(33, bean.getSale27());
            ps.setString(34, bean.getSale28());
            ps.setString(35, bean.getSale29());
            ps.setString(36, bean.getSale30());
            ps.setString(37, bean.getSale31());
            ps.setString(38, bean.getSale32());
            ps.setString(39, bean.getSale33());
            ps.setString(40, bean.getSale34());
            ps.setString(41, bean.getSale35());
            ps.setString(42, bean.getSale36());
            ps.setString(43, bean.getCont0());
            ps.setString(44, bean.getCont1());
            ps.setString(45, bean.getCont2());
            ps.setString(46, bean.getCont3());
            ps.setString(47, bean.getCont4());
            ps.setString(48, bean.getCont5());
            ps.setString(49, bean.getCont6());
            ps.setString(50, bean.getCont7());
            ps.setString(51, bean.getCont8());
            ps.setString(52, bean.getCont9());
            ps.setString(53, bean.getCont10());
            ps.setString(54, bean.getCont11());
            ps.setString(55, bean.getCont12());
            ps.setString(56, bean.getCont13());
            ps.setString(57, bean.getCont14());
            ps.setString(58, bean.getCont15());
            ps.setString(59, bean.getStock0());
            ps.setString(60, bean.getStock01());
            ps.setString(61, bean.getStock1());
            ps.setString(62, bean.getStock2());
            ps.setString(63, bean.getStock3());
            ps.setString(64, bean.getStock4());
            ps.setString(65, bean.getStock5());
            ps.setString(66, bean.getStock6());
            ps.setString(67, bean.getStock7());
            ps.setString(68, bean.getStock8());
            ps.setString(69, bean.getStock9());
            ps.setString(70, bean.getStock10());
            ps.setString(71, bean.getStock11());
            ps.setString(72, bean.getStock12());
            ps.setString(73, bean.getStock13());
            ps.setString(74, bean.getStock14());
            ps.setString(75, bean.getStock15());
            ps.setString(76, bean.getStock16());
            ps.setString(77, bean.getStock17());
            ps.setString(78, bean.getStock18());
            ps.setString(79, bean.getStock19());
            ps.setString(80, bean.getStock20());
            ps.setString(81, bean.getStock21());
            ps.setString(82, bean.getStock22());
            ps.setString(83, bean.getStock23());
            ps.setString(84, bean.getStock24());
            ps.setString(85, bean.getStock25());
            ps.setString(86, bean.getStock26());
            ps.setString(87, bean.getStock27());
            ps.setString(88, bean.getStock28());
            ps.setString(89, bean.getStock29());
            ps.setString(90, bean.getStock30());
            ps.setString(91, bean.getStock31());
            ps.setString(92, bean.getStock32());
            ps.setString(93, bean.getStock33());
            ps.setString(94, bean.getStock34());
            ps.setString(95, bean.getStock35());
            ps.setString(96, bean.getStock36());
            ps.setString(97, bean.getStock37());
            ps.setString(98, bean.getStock38());
            ps.setString(99, bean.getStock39());
            ps.setString(100, bean.getStock40());
            ps.setString(101, bean.getStock41());
            ps.setString(102, bean.getStock42());
            ps.setString(103, bean.getStock43());
            ps.setString(104, bean.getStock44());
            ps.setString(105, bean.getStock45());
            ps.setString(106, bean.getStock46());
            ps.setString(107, bean.getStock47());
            ps.setString(108, bean.getStock48());
            ps.setString(109, bean.getStock49());
            ps.setString(110, bean.getStock50());
            ps.setString(111, bean.getStock51());
            ps.setString(112, bean.getStock52());
            ps.setString(113, bean.getStock53());
            ps.setString(114, bean.getStock54());
            ps.setString(115, bean.getStock55());
            ps.setString(116, bean.getStock56());
            ps.setString(117, bean.getStock57());
            ps.setString(118, bean.getStock58());
            ps.setString(119, bean.getStock59());
            ps.setString(120, bean.getStock60());
            ps.setString(121, bean.getStock61());
            ps.setString(122, bean.getStock62());
            ps.setString(123, bean.getStock63());
            ps.setString(124, bean.getStock64());
            ps.setString(125, bean.getStock65());
            ps.setString(126, bean.getStock66());
            ps.setString(127, bean.getStock67());
            ps.setString(128, bean.getStock68());
            ps.setString(129, bean.getStock69());
            ps.setString(130, bean.getStock70());
            ps.setString(131, bean.getStock71());
            ps.setString(132, bean.getStock72());
            ps.setString(133, bean.getStock73());
            ps.setString(134, bean.getStock74());
            ps.setString(135, bean.getCont16());
            ps.setString(136, bean.getCont17());
            ps.setString(137, bean.getCont18());
            ps.setString(138, bean.getCont19());
            ps.setString(139, bean.getCont20());
            ps.setString(140, bean.getCont21());
            ps.setString(141, bean.getCont22());
            ps.setString(142, bean.getCont23());
            ps.setString(143, bean.getCont24());
            ps.setString(144, bean.getCont25());
            ps.setString(145, bean.getCont26());
            ps.setString(146, bean.getCont27());
            ps.setString(147, bean.getCont28());
            ps.setString(148, bean.getCont29());
            ps.setString(149, bean.getCont30());
            ps.setString(150, bean.getCont31());
            ps.setString(151, bean.getCont32());
            ps.setString(152, bean.getCont33());
            ps.setString(153, bean.getCont34());
            ps.setString(154, bean.getCont35());
            ps.setString(155, bean.getCont36());
            ps.setString(156, bean.getCont37());
            ps.setString(157, bean.getCont38());
            ps.setString(158, bean.getCont39());
            ps.setString(159, bean.getCont40());
            ps.setString(160, bean.getCont41());
            ps.setString(161, bean.getCont42());
            ps.setString(162, bean.getCont43());
            ps.setString(163, bean.getCont44());
            ps.setString(164, bean.getCont45());
            ps.setString(165, bean.getCont46());
            ps.setString(166, bean.getCont47());
            ps.setString(167, bean.getSale37());
            ps.setString(168, bean.getSale38());
            ps.executeUpdate();
            return bean;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error in create", ex);
            return null;
        }
    }

    @Override
    public boolean createList(List<PosuserBean> listBean) {
        for (PosuserBean bean : listBean) {
            if (create(bean) == null) return false;
        }
        return true;
    }

    @Override
    public boolean update(String key, PosuserBean bean) {
        String sql = "UPDATE posuser SET UserName = ?, Password = ?, Name = ?, UserGroup = ?, OnACT = ?, MacNo = ?, Sale1 = ?, Sale2 = ?, Sale3 = ?, Sale4 = ?, Sale5 = ?, Sale6 = ?, Sale7 = ?, Sale8 = ?, Sale9 = ?, Sale10 = ?, Sale11 = ?, Sale12 = ?, Sale13 = ?, Sale14 = ?, Sale15 = ?, Sale16 = ?, Sale17 = ?, Sale18 = ?, Sale19 = ?, Sale20 = ?, Sale21 = ?, Sale22 = ?, Sale23 = ?, Sale24 = ?, Sale25 = ?, Sale26 = ?, Sale27 = ?, Sale28 = ?, Sale29 = ?, Sale30 = ?, Sale31 = ?, Sale32 = ?, Sale33 = ?, Sale34 = ?, Sale35 = ?, Sale36 = ?, Cont0 = ?, Cont1 = ?, Cont2 = ?, Cont3 = ?, Cont4 = ?, Cont5 = ?, Cont6 = ?, Cont7 = ?, Cont8 = ?, Cont9 = ?, Cont10 = ?, Cont11 = ?, Cont12 = ?, Cont13 = ?, Cont14 = ?, Cont15 = ?, Stock0 = ?, Stock0_1 = ?, Stock1 = ?, Stock2 = ?, Stock3 = ?, Stock4 = ?, Stock5 = ?, Stock6 = ?, Stock7 = ?, Stock8 = ?, Stock9 = ?, Stock10 = ?, Stock11 = ?, Stock12 = ?, Stock13 = ?, Stock14 = ?, Stock15 = ?, Stock16 = ?, Stock17 = ?, Stock18 = ?, Stock19 = ?, Stock20 = ?, Stock21 = ?, Stock22 = ?, Stock23 = ?, Stock24 = ?, Stock25 = ?, Stock26 = ?, Stock27 = ?, Stock28 = ?, Stock29 = ?, Stock30 = ?, Stock31 = ?, Stock32 = ?, Stock33 = ?, Stock34 = ?, Stock35 = ?, Stock36 = ?, Stock37 = ?, Stock38 = ?, Stock39 = ?, Stock40 = ?, Stock41 = ?, Stock42 = ?, Stock43 = ?, Stock44 = ?, Stock45 = ?, Stock46 = ?, Stock47 = ?, Stock48 = ?, Stock49 = ?, Stock50 = ?, Stock51 = ?, Stock52 = ?, Stock53 = ?, Stock54 = ?, Stock55 = ?, Stock56 = ?, Stock57 = ?, Stock58 = ?, Stock59 = ?, Stock60 = ?, Stock61 = ?, Stock62 = ?, Stock63 = ?, Stock64 = ?, Stock65 = ?, Stock66 = ?, Stock67 = ?, Stock68 = ?, Stock69 = ?, Stock70 = ?, Stock71 = ?, Stock72 = ?, Stock73 = ?, Stock74 = ?, Cont16 = ?, Cont17 = ?, Cont18 = ?, Cont19 = ?, Cont20 = ?, Cont21 = ?, Cont22 = ?, Cont23 = ?, Cont24 = ?, Cont25 = ?, Cont26 = ?, Cont27 = ?, Cont28 = ?, Cont29 = ?, Cont30 = ?, Cont31 = ?, Cont32 = ?, Cont33 = ?, Cont34 = ?, Cont35 = ?, Cont36 = ?, Cont37 = ?, Cont38 = ?, Cont39 = ?, Cont40 = ?, Cont41 = ?, Cont42 = ?, Cont43 = ?, Cont44 = ?, Cont45 = ?, Cont46 = ?, Cont47 = ?, Sale37 = ?, Sale38 = ? WHERE id = ?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, bean.getUsername());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setString(4, bean.getUsergroup());
            ps.setString(5, bean.getOnact());
            ps.setString(6, bean.getMacno());
            ps.setString(7, bean.getSale1());
            ps.setString(8, bean.getSale2());
            ps.setString(9, bean.getSale3());
            ps.setString(10, bean.getSale4());
            ps.setString(11, bean.getSale5());
            ps.setString(12, bean.getSale6());
            ps.setString(13, bean.getSale7());
            ps.setString(14, bean.getSale8());
            ps.setString(15, bean.getSale9());
            ps.setString(16, bean.getSale10());
            ps.setString(17, bean.getSale11());
            ps.setString(18, bean.getSale12());
            ps.setString(19, bean.getSale13());
            ps.setString(20, bean.getSale14());
            ps.setString(21, bean.getSale15());
            ps.setString(22, bean.getSale16());
            ps.setString(23, bean.getSale17());
            ps.setString(24, bean.getSale18());
            ps.setString(25, bean.getSale19());
            ps.setString(26, bean.getSale20());
            ps.setString(27, bean.getSale21());
            ps.setString(28, bean.getSale22());
            ps.setString(29, bean.getSale23());
            ps.setString(30, bean.getSale24());
            ps.setString(31, bean.getSale25());
            ps.setString(32, bean.getSale26());
            ps.setString(33, bean.getSale27());
            ps.setString(34, bean.getSale28());
            ps.setString(35, bean.getSale29());
            ps.setString(36, bean.getSale30());
            ps.setString(37, bean.getSale31());
            ps.setString(38, bean.getSale32());
            ps.setString(39, bean.getSale33());
            ps.setString(40, bean.getSale34());
            ps.setString(41, bean.getSale35());
            ps.setString(42, bean.getSale36());
            ps.setString(43, bean.getCont0());
            ps.setString(44, bean.getCont1());
            ps.setString(45, bean.getCont2());
            ps.setString(46, bean.getCont3());
            ps.setString(47, bean.getCont4());
            ps.setString(48, bean.getCont5());
            ps.setString(49, bean.getCont6());
            ps.setString(50, bean.getCont7());
            ps.setString(51, bean.getCont8());
            ps.setString(52, bean.getCont9());
            ps.setString(53, bean.getCont10());
            ps.setString(54, bean.getCont11());
            ps.setString(55, bean.getCont12());
            ps.setString(56, bean.getCont13());
            ps.setString(57, bean.getCont14());
            ps.setString(58, bean.getCont15());
            ps.setString(59, bean.getStock0());
            ps.setString(60, bean.getStock01());
            ps.setString(61, bean.getStock1());
            ps.setString(62, bean.getStock2());
            ps.setString(63, bean.getStock3());
            ps.setString(64, bean.getStock4());
            ps.setString(65, bean.getStock5());
            ps.setString(66, bean.getStock6());
            ps.setString(67, bean.getStock7());
            ps.setString(68, bean.getStock8());
            ps.setString(69, bean.getStock9());
            ps.setString(70, bean.getStock10());
            ps.setString(71, bean.getStock11());
            ps.setString(72, bean.getStock12());
            ps.setString(73, bean.getStock13());
            ps.setString(74, bean.getStock14());
            ps.setString(75, bean.getStock15());
            ps.setString(76, bean.getStock16());
            ps.setString(77, bean.getStock17());
            ps.setString(78, bean.getStock18());
            ps.setString(79, bean.getStock19());
            ps.setString(80, bean.getStock20());
            ps.setString(81, bean.getStock21());
            ps.setString(82, bean.getStock22());
            ps.setString(83, bean.getStock23());
            ps.setString(84, bean.getStock24());
            ps.setString(85, bean.getStock25());
            ps.setString(86, bean.getStock26());
            ps.setString(87, bean.getStock27());
            ps.setString(88, bean.getStock28());
            ps.setString(89, bean.getStock29());
            ps.setString(90, bean.getStock30());
            ps.setString(91, bean.getStock31());
            ps.setString(92, bean.getStock32());
            ps.setString(93, bean.getStock33());
            ps.setString(94, bean.getStock34());
            ps.setString(95, bean.getStock35());
            ps.setString(96, bean.getStock36());
            ps.setString(97, bean.getStock37());
            ps.setString(98, bean.getStock38());
            ps.setString(99, bean.getStock39());
            ps.setString(100, bean.getStock40());
            ps.setString(101, bean.getStock41());
            ps.setString(102, bean.getStock42());
            ps.setString(103, bean.getStock43());
            ps.setString(104, bean.getStock44());
            ps.setString(105, bean.getStock45());
            ps.setString(106, bean.getStock46());
            ps.setString(107, bean.getStock47());
            ps.setString(108, bean.getStock48());
            ps.setString(109, bean.getStock49());
            ps.setString(110, bean.getStock50());
            ps.setString(111, bean.getStock51());
            ps.setString(112, bean.getStock52());
            ps.setString(113, bean.getStock53());
            ps.setString(114, bean.getStock54());
            ps.setString(115, bean.getStock55());
            ps.setString(116, bean.getStock56());
            ps.setString(117, bean.getStock57());
            ps.setString(118, bean.getStock58());
            ps.setString(119, bean.getStock59());
            ps.setString(120, bean.getStock60());
            ps.setString(121, bean.getStock61());
            ps.setString(122, bean.getStock62());
            ps.setString(123, bean.getStock63());
            ps.setString(124, bean.getStock64());
            ps.setString(125, bean.getStock65());
            ps.setString(126, bean.getStock66());
            ps.setString(127, bean.getStock67());
            ps.setString(128, bean.getStock68());
            ps.setString(129, bean.getStock69());
            ps.setString(130, bean.getStock70());
            ps.setString(131, bean.getStock71());
            ps.setString(132, bean.getStock72());
            ps.setString(133, bean.getStock73());
            ps.setString(134, bean.getStock74());
            ps.setString(135, bean.getCont16());
            ps.setString(136, bean.getCont17());
            ps.setString(137, bean.getCont18());
            ps.setString(138, bean.getCont19());
            ps.setString(139, bean.getCont20());
            ps.setString(140, bean.getCont21());
            ps.setString(141, bean.getCont22());
            ps.setString(142, bean.getCont23());
            ps.setString(143, bean.getCont24());
            ps.setString(144, bean.getCont25());
            ps.setString(145, bean.getCont26());
            ps.setString(146, bean.getCont27());
            ps.setString(147, bean.getCont28());
            ps.setString(148, bean.getCont29());
            ps.setString(149, bean.getCont30());
            ps.setString(150, bean.getCont31());
            ps.setString(151, bean.getCont32());
            ps.setString(152, bean.getCont33());
            ps.setString(153, bean.getCont34());
            ps.setString(154, bean.getCont35());
            ps.setString(155, bean.getCont36());
            ps.setString(156, bean.getCont37());
            ps.setString(157, bean.getCont38());
            ps.setString(158, bean.getCont39());
            ps.setString(159, bean.getCont40());
            ps.setString(160, bean.getCont41());
            ps.setString(161, bean.getCont42());
            ps.setString(162, bean.getCont43());
            ps.setString(163, bean.getCont44());
            ps.setString(164, bean.getCont45());
            ps.setString(165, bean.getCont46());
            ps.setString(166, bean.getCont47());
            ps.setString(167, bean.getSale37());
            ps.setString(168, bean.getSale38());
            ps.setString(169, key);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error in update", ex);
            return false;
        }
    }

    @Override
    public boolean delete(String key) {
        String sql = "DELETE FROM posuser WHERE id = ?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, key);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error in delete", ex);
            return false;
        }
    }

    @Override
    public List<PosuserBean> findAll() {
        String sql = "SELECT * FROM posuser";
        List<PosuserBean> result = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) result.add(mapRow(rs));
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error in findAll", ex);
        }
        return result;
    }

    @Override
    public PosuserBean findById(PosuserBean bean) {
        String sql = "SELECT * FROM posuser WHERE UserName = ?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, bean.getUsername());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error in findById", ex);
        }
        return null;
    }
    
    public PosuserBean findByUsernameAndPassword(PosuserBean bean) {
        String sql = "SELECT * FROM posuser WHERE UserName = ? and Password = ?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, bean.getUsername());
            ps.setString(2, bean.getPassword());
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error in findByUsernameAndPassword", ex);
        }
        return null;
    }

    private PosuserBean mapRow(ResultSet rs) throws SQLException {
        PosuserBean bean = new PosuserBean();
        bean.setUsername(rs.getString("UserName"));
        bean.setPassword(rs.getString("Password"));
        bean.setName(rs.getString("Name"));
        bean.setUsergroup(rs.getString("UserGroup"));
        bean.setOnact(rs.getString("OnACT"));
        bean.setMacno(rs.getString("MacNo"));
        bean.setSale1(rs.getString("Sale1"));
        bean.setSale2(rs.getString("Sale2"));
        bean.setSale3(rs.getString("Sale3"));
        bean.setSale4(rs.getString("Sale4"));
        bean.setSale5(rs.getString("Sale5"));
        bean.setSale6(rs.getString("Sale6"));
        bean.setSale7(rs.getString("Sale7"));
        bean.setSale8(rs.getString("Sale8"));
        bean.setSale9(rs.getString("Sale9"));
        bean.setSale10(rs.getString("Sale10"));
        bean.setSale11(rs.getString("Sale11"));
        bean.setSale12(rs.getString("Sale12"));
        bean.setSale13(rs.getString("Sale13"));
        bean.setSale14(rs.getString("Sale14"));
        bean.setSale15(rs.getString("Sale15"));
        bean.setSale16(rs.getString("Sale16"));
        bean.setSale17(rs.getString("Sale17"));
        bean.setSale18(rs.getString("Sale18"));
        bean.setSale19(rs.getString("Sale19"));
        bean.setSale20(rs.getString("Sale20"));
        bean.setSale21(rs.getString("Sale21"));
        bean.setSale22(rs.getString("Sale22"));
        bean.setSale23(rs.getString("Sale23"));
        bean.setSale24(rs.getString("Sale24"));
        bean.setSale25(rs.getString("Sale25"));
        bean.setSale26(rs.getString("Sale26"));
        bean.setSale27(rs.getString("Sale27"));
        bean.setSale28(rs.getString("Sale28"));
        bean.setSale29(rs.getString("Sale29"));
        bean.setSale30(rs.getString("Sale30"));
        bean.setSale31(rs.getString("Sale31"));
        bean.setSale32(rs.getString("Sale32"));
        bean.setSale33(rs.getString("Sale33"));
        bean.setSale34(rs.getString("Sale34"));
        bean.setSale35(rs.getString("Sale35"));
        bean.setSale36(rs.getString("Sale36"));
        bean.setCont0(rs.getString("Cont0"));
        bean.setCont1(rs.getString("Cont1"));
        bean.setCont2(rs.getString("Cont2"));
        bean.setCont3(rs.getString("Cont3"));
        bean.setCont4(rs.getString("Cont4"));
        bean.setCont5(rs.getString("Cont5"));
        bean.setCont6(rs.getString("Cont6"));
        bean.setCont7(rs.getString("Cont7"));
        bean.setCont8(rs.getString("Cont8"));
        bean.setCont9(rs.getString("Cont9"));
        bean.setCont10(rs.getString("Cont10"));
        bean.setCont11(rs.getString("Cont11"));
        bean.setCont12(rs.getString("Cont12"));
        bean.setCont13(rs.getString("Cont13"));
        bean.setCont14(rs.getString("Cont14"));
        bean.setCont15(rs.getString("Cont15"));
        bean.setStock0(rs.getString("Stock0"));
        bean.setStock01(rs.getString("Stock0_1"));
        bean.setStock1(rs.getString("Stock1"));
        bean.setStock2(rs.getString("Stock2"));
        bean.setStock3(rs.getString("Stock3"));
        bean.setStock4(rs.getString("Stock4"));
        bean.setStock5(rs.getString("Stock5"));
        bean.setStock6(rs.getString("Stock6"));
        bean.setStock7(rs.getString("Stock7"));
        bean.setStock8(rs.getString("Stock8"));
        bean.setStock9(rs.getString("Stock9"));
        bean.setStock10(rs.getString("Stock10"));
        bean.setStock11(rs.getString("Stock11"));
        bean.setStock12(rs.getString("Stock12"));
        bean.setStock13(rs.getString("Stock13"));
        bean.setStock14(rs.getString("Stock14"));
        bean.setStock15(rs.getString("Stock15"));
        bean.setStock16(rs.getString("Stock16"));
        bean.setStock17(rs.getString("Stock17"));
        bean.setStock18(rs.getString("Stock18"));
        bean.setStock19(rs.getString("Stock19"));
        bean.setStock20(rs.getString("Stock20"));
        bean.setStock21(rs.getString("Stock21"));
        bean.setStock22(rs.getString("Stock22"));
        bean.setStock23(rs.getString("Stock23"));
        bean.setStock24(rs.getString("Stock24"));
        bean.setStock25(rs.getString("Stock25"));
        bean.setStock26(rs.getString("Stock26"));
        bean.setStock27(rs.getString("Stock27"));
        bean.setStock28(rs.getString("Stock28"));
        bean.setStock29(rs.getString("Stock29"));
        bean.setStock30(rs.getString("Stock30"));
        bean.setStock31(rs.getString("Stock31"));
        bean.setStock32(rs.getString("Stock32"));
        bean.setStock33(rs.getString("Stock33"));
        bean.setStock34(rs.getString("Stock34"));
        bean.setStock35(rs.getString("Stock35"));
        bean.setStock36(rs.getString("Stock36"));
        bean.setStock37(rs.getString("Stock37"));
        bean.setStock38(rs.getString("Stock38"));
        bean.setStock39(rs.getString("Stock39"));
        bean.setStock40(rs.getString("Stock40"));
        bean.setStock41(rs.getString("Stock41"));
        bean.setStock42(rs.getString("Stock42"));
        bean.setStock43(rs.getString("Stock43"));
        bean.setStock44(rs.getString("Stock44"));
        bean.setStock45(rs.getString("Stock45"));
        bean.setStock46(rs.getString("Stock46"));
        bean.setStock47(rs.getString("Stock47"));
        bean.setStock48(rs.getString("Stock48"));
        bean.setStock49(rs.getString("Stock49"));
        bean.setStock50(rs.getString("Stock50"));
        bean.setStock51(rs.getString("Stock51"));
        bean.setStock52(rs.getString("Stock52"));
        bean.setStock53(rs.getString("Stock53"));
        bean.setStock54(rs.getString("Stock54"));
        bean.setStock55(rs.getString("Stock55"));
        bean.setStock56(rs.getString("Stock56"));
        bean.setStock57(rs.getString("Stock57"));
        bean.setStock58(rs.getString("Stock58"));
        bean.setStock59(rs.getString("Stock59"));
        bean.setStock60(rs.getString("Stock60"));
        bean.setStock61(rs.getString("Stock61"));
        bean.setStock62(rs.getString("Stock62"));
        bean.setStock63(rs.getString("Stock63"));
        bean.setStock64(rs.getString("Stock64"));
        bean.setStock65(rs.getString("Stock65"));
        bean.setStock66(rs.getString("Stock66"));
        bean.setStock67(rs.getString("Stock67"));
        bean.setStock68(rs.getString("Stock68"));
        bean.setStock69(rs.getString("Stock69"));
        bean.setStock70(rs.getString("Stock70"));
        bean.setStock71(rs.getString("Stock71"));
        bean.setStock72(rs.getString("Stock72"));
        bean.setStock73(rs.getString("Stock73"));
        bean.setStock74(rs.getString("Stock74"));
        bean.setCont16(rs.getString("Cont16"));
        bean.setCont17(rs.getString("Cont17"));
        bean.setCont18(rs.getString("Cont18"));
        bean.setCont19(rs.getString("Cont19"));
        bean.setCont20(rs.getString("Cont20"));
        bean.setCont21(rs.getString("Cont21"));
        bean.setCont22(rs.getString("Cont22"));
        bean.setCont23(rs.getString("Cont23"));
        bean.setCont24(rs.getString("Cont24"));
        bean.setCont25(rs.getString("Cont25"));
        bean.setCont26(rs.getString("Cont26"));
        bean.setCont27(rs.getString("Cont27"));
        bean.setCont28(rs.getString("Cont28"));
        bean.setCont29(rs.getString("Cont29"));
        bean.setCont30(rs.getString("Cont30"));
        bean.setCont31(rs.getString("Cont31"));
        bean.setCont32(rs.getString("Cont32"));
        bean.setCont33(rs.getString("Cont33"));
        bean.setCont34(rs.getString("Cont34"));
        bean.setCont35(rs.getString("Cont35"));
        bean.setCont36(rs.getString("Cont36"));
        bean.setCont37(rs.getString("Cont37"));
        bean.setCont38(rs.getString("Cont38"));
        bean.setCont39(rs.getString("Cont39"));
        bean.setCont40(rs.getString("Cont40"));
        bean.setCont41(rs.getString("Cont41"));
        bean.setCont42(rs.getString("Cont42"));
        bean.setCont43(rs.getString("Cont43"));
        bean.setCont44(rs.getString("Cont44"));
        bean.setCont45(rs.getString("Cont45"));
        bean.setCont46(rs.getString("Cont46"));
        bean.setCont47(rs.getString("Cont47"));
        bean.setSale37(rs.getString("Sale37"));
        bean.setSale38(rs.getString("Sale38"));
        return bean;
    }
}
