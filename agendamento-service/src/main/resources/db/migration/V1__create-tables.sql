CREATE TABLE IF NOT EXISTS "usuario" (
	"id" serial NOT NULL UNIQUE,
	"nome" varchar(255) NOT NULL,
	"login" varchar(25) NOT NULL UNIQUE,
	"senha" varchar(255) NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "perfil" (
	"id" serial NOT NULL UNIQUE,
	"descricao" varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "usuario_perfil" (
	"id" serial NOT NULL UNIQUE,
	"usuario_id" bigint NOT NULL,
	"perfil_id" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "permissao" (
	"id" serial NOT NULL UNIQUE,
	"descricao" varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "perfil_permissao" (
	"id" serial NOT NULL UNIQUE,
	"view" boolean NOT NULL,
	"insert" boolean NOT NULL,
	"update" boolean NOT NULL,
	"delete" boolean NOT NULL,
	"permissao_id" bigint NOT NULL,
	"perfil_id" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "consulta" (
	"id" serial NOT NULL UNIQUE,
	"medico_id" bigint NOT NULL,
	"paciente_id" bigint NOT NULL,
	"data" timestamp without time zone NOT NULL,
	PRIMARY KEY ("id")
);

ALTER TABLE "usuario_perfil" ADD CONSTRAINT "usuario_perfil_fk1" FOREIGN KEY ("usuario_id") REFERENCES "usuario"("id");

ALTER TABLE "usuario_perfil" ADD CONSTRAINT "usuario_perfil_fk2" FOREIGN KEY ("perfil_id") REFERENCES "perfil"("id");

ALTER TABLE "perfil_permissao" ADD CONSTRAINT "perfil_permissao_fk5" FOREIGN KEY ("permissao_id") REFERENCES "permissao"("id");

ALTER TABLE "perfil_permissao" ADD CONSTRAINT "perfil_permissao_fk6" FOREIGN KEY ("perfil_id") REFERENCES "perfil"("id");

ALTER TABLE "consulta" ADD CONSTRAINT "consulta_fk1" FOREIGN KEY ("medico_id") REFERENCES "usuario"("id");

ALTER TABLE "consulta" ADD CONSTRAINT "consulta_fk2" FOREIGN KEY ("paciente_id") REFERENCES "usuario"("id");