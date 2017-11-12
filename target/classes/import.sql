INSERT INTO `product` (id, name, price, available, category_path, description, qty, status, created, creator)
VALUES 
(1,'product1',100,'50','category1','product 1',50,'active',NULL,NULL),
(2,'product 2',150,'20','category1','product 2 ',20,'active',NULL,NULL),
(3,'product 3 ',200,'30','category1','product 3',30,'active',NULL,NULL);

INSERT INTO `category`
(`id`,
`name`,
`path`)
VALUES
(1, 'category', '/category/category'),
(2, 'category1', '/category/category1'),
(3, 'category2', '/category/category2'),
