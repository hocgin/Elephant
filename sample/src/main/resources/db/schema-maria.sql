DROP TABLE IF EXISTS `test_example`;
create table `test_example`
(
  id         varchar(32)
  comment '自增 ID'
    primary key,
  name       varchar(10)                     null,
  type       varchar(10)                     null,
  enable     tinyint(1) unsigned default '0' not null,
  deleted    tinyint(1) unsigned default '0' not null
  comment '0:为正常状态;1:为被删除状态',
  created_at datetime(6)                     not null
  comment '创建时间',
  creator    int(11) unsigned                null
  comment '创建者',
  updated_at datetime(6)                     null
  comment '更新时间',
  updater    int(11) unsigned                null
  comment '更新者',
  deleted_at datetime(6)                     null
  comment '删除时间',
  deleter    int(11) unsigned                null
  comment '删除者'
)
  ENGINE = InnoDB
  comment '例子表'
  charset = utf8mb4;

