package enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 10:32 2021-03-19
 */
public class ConfigMainEnum {
  @Getter
  public enum deleteConfig {
    /** 是否删除1未删除 0删除 */
    DELETE(0, "已删除"),
    NOT_DELETE(1, "未删除");
    private String message;
    private Integer code;

    deleteConfig(Integer code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum approveOptionType {
    /** 审批类型 0驳回 1通过 2转办 */
    REJECT(0, "驳回"),
    PASS(1, "通过"),
    TRANSITION(2, "转办"),
    TRANSITION_PASS(3, "转办通过");
    private String message;
    private Integer code;

    approveOptionType(Integer code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum approveStatus {
    /** 审批状态 0审批驳回1审批中 2审批通过 */
    REJECT(0, "审批驳回"),
    UNDERWAY(1, "审批中"),
    PASS(2, "审批通过");
    private String message;
    private Integer code;

    approveStatus(Integer code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum whetherTheComplaint {
    /** 是否被转办 */
    NOT_COMPLAINT(0, "未转办过"),
    COMPAINT(1, "转办进行中");
    private String message;
    private Integer code;

    whetherTheComplaint(Integer code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum canModify {
    /** 是否可以修改 0不能 1可以 */
    NOT_MODIFY(0, "不能"),
    IS_MODIFY(1, "可以");
    private String message;
    private Integer code;

    canModify(Integer code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum officialType {
    /** 审批类型 0驳回 1通过 2转办 */
    REJECT(0, "驳回"),
    PASS(1, "通过"),
    TRANSITION(2, "转办"),
    AGENT(3, "转办对象通过"),
    RESUBMIT(4, "重新提交");
    private String message;
    private Integer code;

    officialType(Integer code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum templateType {
    /** 是否1通用 2专用 */
    DEDICATED(1, "通用"),
    UNIVERSALITY(2, "专用");
    private String message;
    private Integer code;

    templateType(Integer code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum buttonOptionType {
    /** 1新增 2修改 3删除 4查看<br> */
    OPTION_C(1, "新增") {
      @Override
      public <T, P> T execute(OptionFactory optionFactory, P p) {
        return optionFactory.create(p);
      }
    },
    OPTION_U(2, "修改") {
      @Override
      public <T, P> T execute(OptionFactory optionFactory, P p) {
        return optionFactory.update(p);
      }
    },
    OPTION_D(3, "删除") {
      @Override
      public <T, P> T execute(OptionFactory optionFactory, P p) {
        return optionFactory.delete(p);
      }
    },
    OPTION_R(4, "查看") {
      @Override
      public <T, P> T execute(OptionFactory optionFactory, P p) {
        return optionFactory.read(p);
      }
    };
    private String message;
    private Integer code;

    buttonOptionType(Integer code, String message) {
      this.code = code;
      this.message = message;
    }

    public abstract <T, P> T execute(OptionFactory optionFactory, P p);

    /**
     * 操作类型
     *
     * @param optionType 增删改查
     * @param <T>
     * @return
     */
    /*public static <T, P> T chanageExecute(Integer optionType, OptionFactory optionFactory, P p) {
      if (optionType == null) {
        return null;
      }
      for (buttonOptionType value : buttonOptionType.values()) {
        if (optionType.equals(value.getCode())) {
          return value.execute(optionFactory, p);
        }
      }
      return null;
    }*/
  }

  @Getter
  public enum optionBussinessType {
    /** 业务类型操作定义，配置增删改查 */
    CONFIG_MAIN_PARAM("ConfigMainServiceImpl", "主业务配置"),
    DATA_PERMISSION("DataPermissionServiceImpl", "数据权限配置"),
    SUB_PROCESS_RECORD("subProcessRecordImpl", "修改记录数据"),
    APPROVE_LIST_CONFIG("approveListConfigSerivceImpl", "审批配置列表相关"),
    APPEOVE_NODE_CONFIG("appeoveNodeConfigSerivceImpl", "审批节点详情表"),
    TAB_MENU_SERVICE("tabMenuServiceImpl", "tab及菜单相关"),
    APPROVE_OPERATION("approveOperationImpl", "审批操作对象");
    private String message;
    private String code;

    optionBussinessType(String code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum sonProcessType {
    /** 子流程类型 */
    SON_DATA_PERMISSION("sonDataPermission", "子流程包含内容配置"),
    SON_NODE_PERMISSION("sonNodePermission", "子流程审批节点配置");
    private String message;
    private String code;

    sonProcessType(String code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum approveType {
    /** 类型 1主流程单号 2子流程单号 */
    SON_APPROVE_TYPE(2, "子流程单号"),
    MAIN_APPROVE_TYPE(1, "主流程单号");
    private String message;
    private Integer code;

    approveType(Integer code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum processExecuteStatus {
    /** 单号状态 */
    UNEXECUTED(0, "未执行"),
    EXECUTORY(1, "执行中"),
    EXECUTION_IS_COMPLETED(2, "执行完");
    private String message;
    private Integer code;

    processExecuteStatus(Integer code, String message) {
      this.code = code;
      this.message = message;
    }
  }

  @Getter
  public enum menusAndTabs {
    /*流程*/
    CONFIG_MAIN_NAME("configMainName", "主流程名称"),
    SUB_PROCESS_NAME("subProcessName", "子流程名称"),
    PROCESS_PRIORITY("processPriority", "流程优先级"),
    PROCESS_MENUS("processMenus", "数据查看节点"),
    MODIFIED_MENUS("modifiedMenus", "数据修改节点");
    private String message;
    private String code;

    menusAndTabs(String code, String message) {
      this.code = code;
      this.message = message;
    }

    static Map<String, String> formTrTame =
        new HashMap() {
          {
            put("subProcessName", "子流程名称");
            put("processPriority", "流程优先级");
            put("processMenus", "数据查看节点");
            put("modifiedMenus", "数据修改节点");
          }
        };

    @Getter
    public enum configMainId {
      /** 单号状态 */
      WDXZ("1", "网点新增"),
      BFGT("12", "网点关停-部分关停"),
      QBGT("11", "网点关停-全部关停"),
      QBHB("7", "网点全部合并"),
      BFHB("8", "网点部分合并"),
      QBCF("9", "网点全部拆分"),
      BFCF("10", "网点部分拆分"),
      QWFH("1311", "网点全部转让给现有网点法人-合并经营"),
      QWFD("1312", "网点全部转让给现有网点法人-独立经营"),
      QWSD("1322", "网点全部转让给社会人员-独立经营"),
      BWFH("1411", "网点部分转让给现有网点法人-合并经营"),
      BWFD("1412", "网点部分转让给现有网点法人-独立经营"),
      BWSD("1422", "网点部分社会人员-独立经营"),
      XZDB("151", "代建包-新增中心代建包报价"),
      EZDB("152", "代建包-修改中心代建包报价"),
      XWDD("153", "代建包-新增网点代建包"),
      EWDD("154", "代建包-修改网点代建包"),
      XWDB("155", "代建包-新增网点代建包报价"),
      EWDB("156", "代建包-修改网点代建包报价"),
      MDZY("1611", "面单-增存量补贴-按月结算"),
      MDZR("1612", "面单-增存量补贴-按日结算"),
      MDFY("1621", "面单-分层补贴-按月结算"),
      MDFR("1622", "面单-分层补贴-按日结算");
      private String message;
      private String code;

      configMainId(String code, String message) {
        this.code = code;
        this.message = message;
      }
    }

    public static List<Integer> getBusinessType(List<Integer> list) {
      List<Integer> result = new ArrayList<>();
      for (Integer i : list) {
        if (i.equals(11)) {
          result.add(1);
        }
        if (i.equals(12)) {
          result.add(11);
          result.add(12);
        }
        if (i.equals(13)) {
          result.add(13);
          result.add(14);
        }
        if (i.equals(14)) {
          result.add(9);
          result.add(10);
        }
        if (i.equals(15)) {
          result.add(7);
          result.add(8);
        }
        if (i.equals(31)) {
          result.add(16);
        }
      }
      return result;
    }
  }
}
