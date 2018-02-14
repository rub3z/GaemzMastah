using GaemzMastah.ViewModel;
using System.Windows;


namespace GaemzMastah
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            this.DataContext = new AppStructureViewModel();
        }

    }
}
