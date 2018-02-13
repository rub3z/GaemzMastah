
namespace GaemzMastah.Model
{
    /// <summary>
    /// Information about an application such as its name, icon, and full path.
    /// </summary>
    public class AppItem
    {

        public string FullPath { get; set; }
        public string Name { get; set; }
        public string IconFullPath { get; set; }

        public AppItem(string v0, string v1, string v2)
        {
            FullPath = v0;
            Name = v1;
            IconFullPath = v2;
        }

    }
}
