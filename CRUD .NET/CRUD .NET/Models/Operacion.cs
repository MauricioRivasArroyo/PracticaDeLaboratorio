using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace CRUD.NET.Models
{
    public class Operacion
    {
        [Key]
        public int id { get; set; }

        public string operacion { get; set; }

        public float primero { get; set; }

        public float segundo { get; set; }

        public float resultado { get; set; }




    }
}